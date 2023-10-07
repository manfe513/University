package model.operation

import ext.inRangeTo
import ext.plusMinus
import model.Product
import model.Resource

/**
 * Нарезка стекла по размерам
 */
object CutGlassOperation : Operation(
    requiredProducts = null,
    name = "Нарезка стекла по размерам",
    resources = hashMapOf(
        Resource.WORKER to 2
    ),
    durationMinutes = 10.plusMinus(1),
    product = Product.GLASS_CUTTED
)

/**
 * Сборка рамки
 */
object MakeGlassFrameOperation : Operation(
    requiredProducts = setOf(Product.GLASS_CUTTED),
    name = "Сборка рамки",
    resources = hashMapOf(
        Resource.STAND to 1,
        Resource.WORKER to 1
    ),
    durationMinutes = 20.plusMinus(3),
    product = Product.GLASS_FRAME
)

/**
 * Сушка
 */
object DryGlassPocketOperation : Operation(
    requiredProducts = setOf(Product.GLASS_FRAME),
    name = "Сушка",
    resources = null,
    // для наглядности уменьшили время сушки
    durationMinutes = 60, // 60*24.inRangeTo(60*24*3), // 60*24 = количество минут в 1 сутках
    product = Product.GLASS_POCKET
)