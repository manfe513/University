import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Unconfined
import model.Factory
import model.Resource

@OptIn(DelicateCoroutinesApi::class)
fun main(args: Array<String>) {
    println("Hello World!")

    val factories = createFactories()
    factories.forEach { factory ->
        GlobalScope.run {
            launch(Unconfined) {
                factory.run()
            }
        }
    }

    Thread.currentThread().join();
}

fun createFactories() = hashSetOf(
    Factory(
        1.or(2),
        reqMaxDuration = 120, // для наглядности уменьшим
        localResources = hashMapOf(
            Resource.WORKER to 2,
            Resource.STAND to 1,
            Resource.MACHINE_THIN_CUT to 1,
            Resource.MACHINE_METAL_CUT to 1,
            Resource.MACHINE_WELDING to 1
        )
    )
)
