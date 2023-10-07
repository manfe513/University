import ext.inRangeTo
import ext.orOther
import ext.plusMinus
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
//    Factory(
//        1.orOther(2),
//        reqMaxDuration = 120, // для наглядности уменьшим
//        localResources = hashMapOf(
//            Resource.WORKER to 2,
//            Resource.STAND to 1,
//            Resource.MACHINE_THIN_CUT to 1,
//            Resource.MACHINE_METAL_CUT to 1,
//            Resource.MACHINE_WELDING to 1
//        )
//    ),
//    Factory(
//        reqPerHour = 1.orOther(2),
//        reqMaxDuration = 90, // для наглядности уменьшим
//        localResources = hashMapOf(
//            Resource.WORKER to 3,
//            Resource.STAND to 1,
//            Resource.MACHINE_THIN_CUT to 1,
//            Resource.MACHINE_METAL_CUT to 1,
//            Resource.MACHINE_WELDING to 1
//        )
//    ),
    Factory(
        reqPerHour = 3.plusMinus(1),
        reqMaxDuration = 90.orOther(120), // для наглядности уменьшим
        localResources = hashMapOf(
            Resource.WORKER to 3,
            Resource.STAND to 2,
            Resource.MACHINE_THIN_CUT to 2,
            Resource.MACHINE_METAL_CUT to 2,
            Resource.MACHINE_WELDING to 2
        )
    ),
//    Factory(
//        3.plusMinus(1),
//        reqMaxDuration = 90.orOther(120), // для наглядности уменьшим
//        localResources = hashMapOf(
//            Resource.WORKER to 4,
//            Resource.STAND to 2,
//            Resource.MACHINE_THIN_CUT to 2,
//            Resource.MACHINE_METAL_CUT to 2,
//            Resource.MACHINE_WELDING to 2
//        )
//    ),
//    Factory(
//        2.inRangeTo(4),
//        reqMaxDuration = 90.orOther(150), // для наглядности уменьшим
//        localResources = hashMapOf(
//            Resource.WORKER to 6,
//            Resource.STAND to 2,
//            Resource.MACHINE_THIN_CUT to 2,
//            Resource.MACHINE_METAL_CUT to 2,
//            Resource.MACHINE_WELDING to 2
//        )
//    ),
)
