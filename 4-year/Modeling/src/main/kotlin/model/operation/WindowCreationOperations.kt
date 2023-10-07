package model.operation

import ext.plusMinus
import model.Resource
import model.Product

object CutProfileOperation : Operation(
    requiredProducts = null,
    order = 1,
    name = "Резка профиля",
    resources = hashMapOf(
        Resource.MACHINE_THIN_CUT to 1,
        Resource.WORKER to 1
    ),
    durationMinutes = 35.plusMinus(2),
    product = Product.PROFILE_WORKPIECE
)
object CutAmplifierOperation : Operation(
    requiredProducts = null,
    order = 2,
    name = "Резка усилителя",
    resources = hashMapOf(
        Resource.MACHINE_METAL_CUT to 1,
        Resource.WORKER to 1
    ),
    durationMinutes = 58.plusMinus(4),
    product = Product.PROFILE_WITH_AMPLIFIER
)
object WeldingOperation : Operation(
    requiredProducts = setOf(
        Product.PROFILE_WORKPIECE,
        Product.PROFILE_WITH_AMPLIFIER
    ),
    order = 3,
    name = "Сварка",
    resources = hashMapOf(
        Resource.MACHINE_WELDING to 1,
        Resource.WORKER to 1
    ),
    durationMinutes = 20.plusMinus(2),
    product = Product.PROFILE_CONNECTED
)
object CleanOperation : Operation(
    requiredProducts = setOf(Product.PROFILE_CONNECTED),
    order = 4,
    name = "Очистка",
    resources = hashMapOf(
        Resource.WORKER to 1
    ),
    durationMinutes = 170.plusMinus(10),
    product = Product.PROFILE_CLEANED
)
object SetDetailsOperation : Operation(
    requiredProducts = setOf(Product.PROFILE_CLEANED),
    order = 5,
    name = "Установка деталей",
    resources = hashMapOf(
        Resource.WORKER to 1
    ),
    durationMinutes = 60.plusMinus(7),
    product = Product.PROFILE_DONE
)
object FinishWindowOperation : Operation(
    requiredProducts = setOf(
        Product.GLASS_POCKET,
        Product.PROFILE_DONE
    ),
    order = 6,
    name = "Остекление стеклопакетом",
    resources = hashMapOf(
        Resource.WORKER to 2
    ),
    durationMinutes = 20.plusMinus(2),
    product = Product.WINDOW_DONE
)