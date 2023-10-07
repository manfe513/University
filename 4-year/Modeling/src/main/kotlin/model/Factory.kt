package model

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import model.operation.*
import java.util.Date
import kotlin.coroutines.CoroutineContext
import kotlin.random.Random

class Factory(

    val reqPerHour: Int,
    val reqMaxDuration: Int,

    val localResources: HashMap<Resource, Int>
) : CoroutineScope {

    // что уже на складе, т.е. локально
    private var localProducts = linkedMapOf<Product, Int>()
    private val mutex = Mutex()

    private var requestQueue = linkedSetOf<Request>()

    // кол-во штрафов
    private var fines: Int = 0

    suspend fun run() {
        // будет выполняться пока работает программа
        launch {
            while (true) {
                mutex.withLock {
                    for (i in 1..reqPerHour) {
                        requestQueue += Request(Date().time)
                    }
                }
                delay(60*10) // в 100 раз уменьшили задержку, т.к. в миллисек
            }
        }

        while (true) {
            mutex.withLock {
                if (requestQueue.size >0) {
                    checkOperationToRun()
                }
            }
            // задержка номинальная, чтобы не забить всю память в стеке
            delay(10)
        }
    }

    private suspend fun checkOperationToRun() {

        // если профиль и стеклопакет на складе - доделать конструкцию
        if (
            localProducts.contains(Product.PROFILE_DONE)
            && localProducts.contains(Product.GLASS_POCKET)
        ) {
            delay(10)
            launch { runProfileCreation() }
            return
        }

        // если профиль уже на складе, а стеклопакета к нему в пару нет - делать стеклопакет
        if (
            localProducts.contains(Product.PROFILE_DONE)
            && localProducts.contains(Product.GLASS_POCKET).not()
        ) {
            delay(10)
            launch { runGlassCreation() }
            return
        }

        // сначала пробуем создать профиль с окном сразу, а потом стекло
        // (от конечной стадии к начальным)
        launch { runProfileCreation() }
        launch { runGlassCreation() }
    }

    // запуск процесса создания стеклопакета
    private suspend fun runGlassCreation() {

        // проверяем, можем ли мы закончить ОКНО
        pickOperationFromFlow(OperationsFlow.glassCreation)
            ?.let { runOperation(it) }

    }

    // запуск процесса создания профиля окна
    private suspend fun runProfileCreation() {
        // теперь проверяем, можем ли сделать стеклопакет
        pickOperationFromFlow(OperationsFlow.profileCreation)
            ?.let { runOperation(it) }
    }

    // выбор операции из процесса (flow)
    // процессы: создание стеклопакета или профиля
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

            if (operation.product == Product.WINDOW_DONE) {
                finishRequest()
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

    private fun finishRequest() {
        val request = requestQueue.first()

        if((Date().time - request.timeCreated)/1000 > reqMaxDuration)
            fines++

        requestQueue.remove(request)
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
        println("- Штрафов: $fines")
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Unconfined + CoroutineExceptionHandler { coroutineContext, throwable ->
            throwable.printStackTrace()
        }
}