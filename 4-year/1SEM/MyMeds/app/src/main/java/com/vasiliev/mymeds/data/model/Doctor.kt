package com.vasiliev.mymeds.data.model

import java.util.UUID

data class Doctor (
    val id: String = UUID.randomUUID().toString(),
    val hospital: Hospital,
    val fullName: String,
    val specialization: String
)  {
    companion object {
        const val COLLECTION_NAME = "doctors"

        const val FIELD_HOSPITAL = "hospital"
        const val FIELD_FULL_NAME = "fullName"
        const val FIELD_SPECIALIZATION = "specialization"
    }
}