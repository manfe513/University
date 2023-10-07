package model.operation

import model.Resource
import model.Product

sealed class Operation(
    val requiredProducts: Set<Product>? = null,

    val name: String,
    val resources: HashMap<Resource, Int>?,
    val durationMinutes: Int,
    val product: Product
)