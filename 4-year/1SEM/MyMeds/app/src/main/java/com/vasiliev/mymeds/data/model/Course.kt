package com.vasiliev.mymeds.data.model

import java.time.LocalTime
import java.util.Date
import java.util.UUID

data class Course (
    val id: String = UUID.randomUUID().toString(),
    val drug: Drug,
    val drugUseType: DrugUseType,
    val alarmTime: LocalTime,
    val dateStart: Date,
    val dateEnd: Date
)  {
    companion object {
        const val COLLECTION_NAME = "courses"

        const val FIELD_DRUG = "drug"
        const val FIELD_DRUG_USE_TYPE = "drugUseType"
        const val FIELD_DATE_START = "dateStart"
        const val FIELD_DATE_END = "dateEnd"
    }
}