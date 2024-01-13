package com.vasiliev.mymeds.helper

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.vasiliev.mymeds.data.model.Course
import java.time.Instant
import java.time.LocalTime
import java.util.Calendar

object AlarmSetter {

    fun set(
        context: Context,
        course: Course
    ) {
        val calendar: Calendar = Calendar.getInstance().apply {
            timeInMillis = Instant.now().toEpochMilli()

            set(Calendar.HOUR_OF_DAY, course.alarmTime.hour)
            set(Calendar.MINUTE, course.alarmTime.minute)
        }

        val alarmMgr = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val alarmIntent = Intent(context, AlarmReceiver::class.java).let { intent ->
            PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_IMMUTABLE)
        }

        alarmMgr.setInexactRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            alarmIntent
        )
    }
}