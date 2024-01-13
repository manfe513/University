package com.vasiliev.mymeds.helper

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.net.Uri
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.vasiliev.mymeds.MainActivity
import com.vasiliev.mymeds.R

//wip
object NotificationHelper {

    fun show(
        context: Context,
        title: String,
        text: String
    ) {
            val intent = Intent(context, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            val pendingIntent: PendingIntent =
                PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_ONE_SHOT)
            val channelId: String = context.getString(R.string.default_notification_channel_id)
            val defaultSoundUri: Uri = RingtoneManager.getDefaultUri(2)
            val notificationBuilder: NotificationCompat.Builder = Builder(context, channelId)
                .setColor(ContextCompat.getColor(context, android.R.color.holo_red_dark))
                .setSmallIcon(R.drawable.ic_stat_name)
                .setContentTitle(title)
                .setContentText(message).setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setSound(defaultSoundUri).setContentIntent(pendingIntent)

            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                    ?: return

            // Since android Oreo notification channel is needed.
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(channelId, "Default Channel", NotificationManager.IMPORTANCE_HIGH)
                notificationManager.createNotificationChannel(channel)
            }
            notificationManager.notify(Random().nextInt(), notificationBuilder.build())
    }
}