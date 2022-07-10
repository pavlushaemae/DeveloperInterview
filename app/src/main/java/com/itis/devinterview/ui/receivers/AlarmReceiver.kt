package com.itis.devinterview.ui.receivers

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.itis.devinterview.R
import com.itis.devinterview.ui.activity.MainActivity

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val i = Intent(context, MainActivity::class.java)
        intent!!.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = createPendingIntentGetActivity(context, 0, i, 0)
        val builder = NotificationCompat.Builder(context!!, "channelId")
            .setSmallIcon(R.mipmap.ic_launcher_round)
            .setContentTitle("It's code time!")
            .setContentText("You're just a few minutes away from learning something new.")
            .setAutoCancel(true)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)

        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(123, builder.build())
    }

    private fun createPendingIntentGetActivity(
        context: Context?,
        id: Int,
        intent: Intent?,
        flag: Int
    ): PendingIntent? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            PendingIntent.getActivity(context, id, intent, PendingIntent.FLAG_IMMUTABLE or flag)
        } else {
            PendingIntent.getActivity(context, id, intent, flag)
        }
    }
}