package model.operation

import ext.inRangeTo
import ext.plusMinus
import model.Product
import model.Resource

object CutGlassOperation : Operation(
    requiredProducts = null,
    order = 1,
    name = "Нарезка стекла по размерам",
    resources = hashMapOf(
        Resource.WORKER to 2
    ),
    durationMinutes = 10.plusMinus(1),
    product = Product.GLASS_CUTTED
)
object MakeGlassFrameOperation : Operation(
    requiredProducts = setOf(Product.GLASS_CUTTED),
    order = 2,
    name = "Сборка рамки",
    resources = hashMapOf(
        Resource.STAND to 1,
        Resource.WORKER to 1
    ),
    durationMinutes = 20.plusMinus(3),
    product = Product.GLASS_FRAME
)
object DryGlassPocketOperation : Operation(
    requiredProducts = setOf(Product.GLASS_FRAME),
    order = 3,
    name = "Сушка",
    resources = null,
    durationMinutes = 60, // 60*24.inRangeTo(60*24*3), // 60*24 = количество минут в 1 сутках
    product = Product.GLASS_POCKET
)