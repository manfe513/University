package model

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import model.operation.*
import java.util.LinkedList
import java.util.concurrent.Executors
import kotlin.coroutines.CoroutineContext
import kotlin.system.exitProcess

class Factory(

    val reqPerHour: Int,
    val reqMaxDuration: Int,

    val localResources: HashMap<Resource, Int>
) : CoroutineScope {

    private var localProducts = hashMapOf<Product, Int>()
    private val mutex = Mutex()

    suspend fun run() {
        while (true) {
            launch { checkOperationToRun() }
            delay(10)
        }
    }

    private suspend fun checkOperationToRun() {
//        println("----------- Thread: ${Thread.currentThread().name}")


        launch {
            // проверяем, можем ли мы закончить ОКНО
            pickOperationFromFlow(OperationsFlow.windowCreation)
                ?.let { runOperation(it) }

        }

        launch {
            // теперь проверяем, можем ли сделать стеклопакет
            pickOperationFromFlow(OperationsFlow.glassCreation)
                ?.let { runOperation(it) }
        }
    }

    private fun pickOperationFromFlow(flow: List<Operation>): Operation? =
        flow.reversed()
            .firstOrNull { operation ->
                val hasRequiredProducts = operation.requiredProducts
                    ?.all { reqProduct -> localProducts.contains(reqProduct) }
                    ?: true

                return@firstOrNull hasRequiredProducts
                        && hasResourcesForOperation(operation)
            }


    private suspend fun runOperation(operation: Operation) = with(operation) {

        println("----------- >> Операция: ${operation.name}")
        printFactoryResources()

        println(">> Операция начата")

        mutex.withLock {
            // забираем со склада готовые детали, требуемые для операции
            requiredProducts?.forEach { reqProduct ->
                if (localProducts[reqProduct]!! > 1) {
                    localProducts[reqProduct] = localProducts[reqProduct]!! - 1
                } else {
                    localProducts.remove(reqProduct)
                }
            }

            // занимаем ресурсы
            resources?.forEach { reqResource ->
                if (localResources[reqResource.key]!! > reqResource.value) {
                    localResources[reqResource.key] = localResources[reqResource.key]!! - reqResource.value
                } else {
                    localResources.remove(reqResource.key)
                }
            }
        }

        // уменьшили задержку в 100 раз, должно быть * 1000.toLong(), т.к. значение в миллисекундах
        delay(operation.durationMinutes * 10.toLong())

        mutex.withLock {
            // добавляем промежуточный продукт "на склад"
            when (val count = localProducts[operation.product]) {
                null -> localProducts[operation.product] = 1
                else -> localProducts[operation.product] = count + 1
            }

            // возвращаем ресурсы
            resources?.forEach { reqResource ->
                when (val count = localResources[reqResource.key]) {
                    null -> localResources[reqResource.key] = reqResource.value
                    else -> localResources[reqResource.key] = count + reqResource.value
                }
            }
        }

        println("------------- << Операция окончена")
        printFactoryResources()
    }

    private fun hasResourcesForOperation(operation: Operation) =
        operation.resources
            ?.all { reqResource ->
                localResources.keys.contains(reqResource.key)
                        && localResources[reqResource.key]!! >= reqResource.value
            } ?: true

    private fun printFactoryResources() {
        println("- ресурсы предприятия:")
        localResources.forEach {
            println("   ${it.key} = ${it.value}")
        }
        println("- промежуточные продукты:")
        localProducts.forEach {
            println("   ${it.key} = ${it.value}")
        }
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Unconfined + CoroutineExceptionHandler { coroutineContext, throwable ->
            throwable.printStackTrace()
        }
}