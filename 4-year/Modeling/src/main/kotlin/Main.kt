import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Unconfined

@OptIn(DelicateCoroutinesApi::class)
fun main(args: Array<String>) {
    println("Hello World!")

    GlobalScope.run {
        runBlocking {
            val jobs = FactoriesCreator.create()
                .map { factory ->
                    launch(Unconfined) { factory.run() }
                }
            delay(Const.WORKING_PERIOD_MINUTES.toLong())
            jobs.forEach {
                it.cancel()
                it.join()
            }
        }
    }
}
