package model

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import model.operation.*
import kotlin.coroutines.CoroutineContext

class Factory(

    val reqPerHour: Int,
    val reqMaxDuration: Int,

    val localResources: HashMap<Resource, Int>
) : CoroutineScope {

    // что уже на складе, т.е. локально
    private var localProducts = linkedMapOf<Product, Int>()
    private val mutex = Mutex()

    suspend fun run() {
        // будет выполняться пока работает программа
        while (true) {
            launch { checkOperationToRun() }
            // задержка номинальная, чтобы не забить всю память в стеке
            delay(10)
        }
    }

    private suspend fun checkOperationToRun() {

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