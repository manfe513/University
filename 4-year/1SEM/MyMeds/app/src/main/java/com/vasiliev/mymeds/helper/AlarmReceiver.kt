package com.vasiliev.mymeds.helper

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(
        context: Context?,
        intent: Intent
    ) {
        //you might want to check what's inside the Intent
        if (intent.getStringExtra("myAction") != null &&
            intent.getStringExtra("myAction").equals("notify")
        ) {
            val manager: NotificationManager = context.getSystemService<NotificationManager>(Context.NOTIFICATION_SERVICE) a
            val builder: NotificationCompat.Builder = Builder(context)
                .setSmallIcon(R.drawable.yourIcon) //example for large icon
                .setLargeIcon(BitmapFactory.decodeResource(context.resources, R.mipmap.ic_launcher))
                .setContentTitle("my title")
                .setContentText("my message")
                .setOngoing(false)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)
            val i = Intent(context, YourTargetActivity::class.java)
            val pendingIntent: PendingIntent = PendingIntent.getActivity(
                context,
                0,
                i,
                PendingIntent.FLAG_ONE_SHOT
            )
            // example for blinking LED
            builder.setLights(-0x48e3e4, 1000, 2000)
            builder.setContentIntent(pendingIntent)
            manager.notify(NOTIFICATION_ID, builder.build())
        }
    }

    companion object {
        const val NOTIFICATION_ID = 12345

    }
}