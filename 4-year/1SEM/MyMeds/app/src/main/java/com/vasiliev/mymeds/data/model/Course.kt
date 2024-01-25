package com.vasiliev.mymeds.data.model

import java.time.LocalTime
import java.util.Date
import java.util.UUID

data class Course (
    val id: String = UUID.randomUUID().toString(),
    val doctor: Doctor,
    val drug: Drug,
    val foodCompatibility: FoodCompatibility,
    val alarmTime: LocalTime,
    val dateStart: Date,
    val dateEnd: Date
)  {
    companion object {
        const val COLLECTION_NAME = "courses"

        const val FIELD_DRUG = "drug"
        const val FIELD_DRUG_FOOD_COMPATIBILITY = "foodCompatibility"
        const val FIELD_DATE_START = "dateStart"
        const val FIELD_DATE_END = "dateEnd"
    }
}