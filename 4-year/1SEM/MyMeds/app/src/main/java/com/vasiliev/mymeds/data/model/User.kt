package com.vasiliev.mymeds.data.model

data class User (
    val id: String? = null,
    val name: String? = null,
    val age: Int? = null,
    val email: String? = null
) {


    companion object {
        const val USER_ID_LOCAL = "local"
        const val COLLECTION_NAME = "users"
    }
}