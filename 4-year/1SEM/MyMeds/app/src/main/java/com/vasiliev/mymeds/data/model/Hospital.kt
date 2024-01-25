package com.vasiliev.mymeds.data.model

import java.util.UUID

data class Hospital (
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val address: String
)  {
    companion object {
        const val COLLECTION_NAME = "hospitals"

        const val FIELD_NAME = "name"
        const val FIELD_ADDRESS = "address"
    }
}