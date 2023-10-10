import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers.Unconfined
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
fun main(args: Array<String>) {
    println("Hello World!")

    FactoriesCreator.create()
        .forEach { factory ->
            GlobalScope.run {
                launch(Unconfined) {
                    factory.run()
                }
            }
        }

    Thread.currentThread().join()
}
