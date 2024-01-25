package com.vasiliev.mymeds.helper

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.vasiliev.mymeds.data.Repo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(
        context: Context?,
        intent: Intent
    ) {
        val courseId = intent.getStringExtra("course_id")
        if(courseId == null) {
            Log.i("MyMeds AlarmReceiver", "onReceive: courseId is null")
        }

        GlobalScope.launch {
            val course = Repo.getCourse(courseId!!).collect { course ->
                withContext(Dispatchers.Main) {
                    NotificationHelper.show(context!!, title = "MyMeds", text = "Время приёма ${course!!.drug.name}")
                }
            }
        }
    }

    companion object {
        const val NOTIFICATION_ID = 12345

    }
}