package model.operation

import model.Resource
import model.Product

/**
 * Операция, выполняемая предприятием
 */
sealed class Operation(
    // требуемые промежуточные готовые продукты
    val requiredProducts: Set<Product>? = null,

    // название операции
    val name: String,
    // требуемые ресурсы предприятия
    val resources: HashMap<Resource, Int>?,
    // длительность операции в минутах
    val durationMinutes: Int,
    // тип получаемого по завершении операции продукта
    val product: Product
)