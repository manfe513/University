package model

import Const.MILLIS_IN_MINUTE
import OperationRunner
import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import model.operation.*
import java.util.Date
import kotlin.coroutines.CoroutineContext

/**
 * Описание структуры предприятия
 */
class Factory(

    // число поступающих запросов на оконные конструкции в час
    val reqPerHour: Int,
    // максимальное время выполнения одной операции
    val reqMaxDuration: Int,

    // локальные ресурсы предприятия
    val localResources: HashMap<Resource, Int>
) : CoroutineScope {

    // что уже на складе, т.е. локально
    private var localProducts = linkedMapOf<Product, Int>()
    private val mutex = Mutex()

    private var requestQueue = linkedSetOf<Request>()
    private var requestQueueInProgress = linkedSetOf<Request>()

    // кол-во штрафов
    private var fines: Int = 0

    private val operationRunner = OperationRunner(factory = this)

    suspend fun run() {
        launch { runRequestGenerator() }
        launch { runRequestQueueChecker() }
    }

    /**
     * Создает reqPerHour заявок 1 раз в час
     */
    private suspend fun runRequestGenerator() {
        // будет выполняться пока работает программа
        while (true) {
            mutex.withLock {
                for (i in 1..reqPerHour) {
                    requestQueue += Request(Date().time)
                }
            }
            delay(60L * MILLIS_IN_MINUTE)
        }
    }

    suspend fun hasProduct(product: Product) = mutex.withLock { localProducts.contains(product) }

    private suspend fun runRequestQueueChecker() {
        while (true) {
            mutex.withLock {
                if (requestQueue.size > 0) {
                    val req = requestQueue.first()
                    requestQueue.remove(req)
                    requestQueueInProgress.add(req)

                    operationRunner.runNextOperation()
                }
            }
            // задержка номинальная, чтобы не забить всю память в стеке
            delay(MILLIS_IN_MINUTE.toLong())
        }
    }

    suspend fun hasResourcesForOperation(operation: Operation): Boolean = mutex.withLock {
        val hasRequiredProducts = operation.requiredProducts
            ?.all { reqProduct -> localProducts.contains(reqProduct) }
            ?: true

        val hasResources = operation.resources
            ?.all { reqResource ->
                localResources.keys.contains(reqResource.key)
                        && localResources[reqResource.key]!! >= reqResource.value
            } ?: true

        return hasRequiredProducts
                && hasResources
    }

    suspend fun consumeResources(operation: Operation) = with(operation) {
        mutex.withLock {
            // забираем со склада готовые детали, требуемые для операции
            requiredProducts?.forEach { reqProduct ->
                when (localProducts[reqProduct]!! > 1) {
                    true -> localProducts[reqProduct]!! - 1
                    else -> localProducts.remove(reqProduct)
                }
            }

            // занимаем ресурсы
            resources?.forEach { reqResource ->

                when (localResources[reqResource.key]!! > reqResource.value) {

                    true -> localResources[reqResource.key] =
                        localResources[reqResource.key]!! - reqResource.value

                    else -> localResources.remove(reqResource.key)
                }
            }
        }
    }

    suspend fun releaseResources(operation: Operation) = with(operation) {
        mutex.withLock {
            resources?.forEach { reqResource ->
                when (val count = localResources[reqResource.key]) {
                    null -> localResources[reqResource.key] = reqResource.value
                    else -> localResources[reqResource.key] = count + reqResource.value
                }
            }
        }
    }

    suspend fun finishRequest() = mutex.withLock {
        val request = requestQueueInProgress.first()

        if ((Date().time - request.timeCreated) / MILLIS_IN_MINUTE > reqMaxDuration)
            fines++

        requestQueueInProgress.remove(request)
    }

    suspend fun addProduct(product: Product) = mutex.withLock {

        when (val count = localProducts[product]) {
            null -> localProducts[product] = 1
            else -> localProducts[product] = count + 1
        }
    }

    suspend fun printFactoryResources() = mutex.withLock {
        println("- ресурсы предприятия:")
        localResources.forEach {
            println("   ${it.key} = ${it.value}")
        }
        println("- промежуточные продукты:")
        localProducts.forEach {
            println("   ${it.key} = ${it.value}")
        }
        println("- Штрафов: $fines")
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Unconfined + CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()
        }
}