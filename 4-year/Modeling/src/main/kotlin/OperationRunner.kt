import kotlinx.coroutines.*
import model.Factory
import model.Product
import model.operation.Operation
import model.operation.OperationsFlow
import kotlin.coroutines.CoroutineContext

/**
 * Вспомогательный класс для запуска операций из процессов
 */
class OperationRunner(
    private val factory: Factory
) : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Unconfined + CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()
        }

    suspend fun runNextOperation() {

        launch { runGlassCreation() }
        // сначала пробуем создать профиль с окном сразу, а потом стекло
        // (от конечной стадии к начальным)
        launch { runProfileCreation() }
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

    // выбор операции из процессов: создать стеклопакет или профиль
    private suspend fun pickOperationFromFlow(flow: List<Operation>): Operation? =
        flow.reversed()
            .firstOrNull { operation -> factory.hasResourcesForOperation(operation) }

    private suspend fun runOperation(operation: Operation) = with(operation) {

        println("----------- >> Начало операциии: ${operation.name}")
        factory.printFactoryResources()

        // занимаем необходимые для операции ресурсы и промежуточные продукты
        factory.consumeResources(operation)

        // задержка = выполнение операции
        delay(operation.durationMinutes * Const.MILLIS_IN_MINUTE.toLong())

        // добавляем промежуточный продукт "на склад"
        factory.addProduct(product)

        // если изготовили всю оконную конструкцию - проверить время на штраф
        if (operation.product == Product.WINDOW_DONE) {
            factory.finishRequest()
        }

        // освободить занятые дял операции ресурсы
        factory.releaseResources(this)

        println("------------- << Операция окончена")
        factory.printFactoryResources()
    }
}