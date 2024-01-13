package com.vasiliev.mymeds.ext

import java.time.LocalDateTime
import java.time.ZoneId

fun LocalDateTime.toTimestamp(zone: ZoneId = ZoneId.systemDefault()) = Timestamp(zone).toEpochSecond(), nano)