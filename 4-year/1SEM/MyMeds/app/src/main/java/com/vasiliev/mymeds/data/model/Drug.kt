package com.vasiliev.mymeds.data.model

import java.util.UUID

data class Drug (
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val description: String,
    val type: DrugType
) {

    companion object {
        const val COLLECTION_NAME = "drug"
    }
}