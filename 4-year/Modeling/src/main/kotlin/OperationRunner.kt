import kotlinx.coroutines.*
import kotlinx.coroutines.sync.withLock
import model.Factory
import model.Product
import model.operation.Operation
import model.operation.OperationsFlow
import kotlin.coroutines.CoroutineContext

class OperationRunner(
    private val factory: Factory
) : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Unconfined + CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()
        }

    suspend fun runNextOperation() {

        // если профиль уже на складе, а стеклопакета к нему в пару нет - делать стеклопакет
//        if (
//            localProducts.contains(Product.PROFILE_DONE)
//            && localProducts.contains(Product.GLASS_POCKET).not()
//        ) {
//            delay(MILLIS_IN_MINUTE.toLong())
//            launch { runGlassCreation() }
//            return
//        }

        // сначала пробуем создать профиль с окном сразу, а потом стекло
        // (от конечной стадии к начальным)
//        launch { runProfileCreation() }
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
    private suspend fun pickOperationFromFlow(flow: List<Operation>): Operation? =
        flow.reversed()
            .firstOrNull { operation -> factory.hasResourcesForOperation(operation) }

    private suspend fun runOperation(operation: Operation) = with(operation) {

        println("----------- >> Начало операциии: ${operation.name}")
        factory.printFactoryResources()

        factory.consumeResources(operation)

        // задержка = выполнение операции
        delay(operation.durationMinutes * Const.MILLIS_IN_MINUTE.toLong())

        // добавляем промежуточный продукт "на склад"
        factory.addProduct(product)

        if (operation.product == Product.WINDOW_DONE) {
            factory.finishRequest()
        }

        factory.releaseResources(this)

        println("------------- << Операция окончена")
        factory.printFactoryResources()
    }
}