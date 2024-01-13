package com.vasiliev.mymeds.model

import java.util.Date

data class Course (
    val drug: Drug,
    val drugUseType: DrugUseType,
    val dateStart: Date,
    val dateEnd: Date
)