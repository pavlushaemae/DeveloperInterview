package com.itis.devinterview.ui.fragment

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import com.itis.devinterview.databinding.FragmentConfigureNotificationsBinding
import com.itis.devinterview.ui.receivers.AlarmReceiver
import java.util.*


class ConfigureNotificationsFragment :
    Fragment(com.itis.devinterview.R.layout.fragment_configure_notifications) {

    private var _binding: FragmentConfigureNotificationsBinding? = null
    private val binding get() = _binding!!
    private lateinit var picker: MaterialTimePicker
    private var calendar: Calendar? = null
    private lateinit var alarmManager: AlarmManager
    private lateinit var pendingIntent: PendingIntent

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentConfigureNotificationsBinding.bind(view)
        createNotificationChannel()

        with(binding) {
            btnSelectTime.setOnClickListener {
                showTimePicker()
            }
            btnSetNotificationTime.setOnClickListener {
                setAlarm()
            }
            btnOffNotifications.setOnClickListener {
                cancelAlarm()
            }
        }
    }

    private fun cancelAlarm() {
        alarmManager =
            requireActivity().getSystemService(Context.ALARM_SERVICE) as AlarmManager //require
        val intent = Intent(activity, AlarmReceiver::class.java)
        pendingIntent = createPendingIntentGetBroadcast(activity, 0, intent, 0)
        alarmManager.cancel(pendingIntent)
        Toast.makeText(context, "Уведомления отключены", Toast.LENGTH_LONG).show()
    }

    private fun setAlarm() {
        alarmManager = requireActivity().getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(activity, AlarmReceiver::class.java)
        pendingIntent = createPendingIntentGetBroadcast(activity, 0, intent, 0)
        if (calendar != null) {
            alarmManager.setRepeating(
                AlarmManager.RTC_WAKEUP,
                calendar!!.timeInMillis,
                AlarmManager.INTERVAL_DAY,
                pendingIntent
            )
            Toast.makeText(context, "Уведомления успешно назначены", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Выберите время", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showTimePicker() {
        picker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Select Alarm Time")
            .build()

        requireActivity().supportFragmentManager.let { picker.show(it, "channelId") }
        picker.addOnPositiveButtonClickListener {
            if (picker.hour > 12) {
                binding.tvSelectedTime.text =
                    String.format("%02d", picker.hour - 12) + " : " + String.format(
                        "%02d",
                        picker.minute
                    ) + " PM"
            } else {
                binding.tvSelectedTime.text =
                    String.format("%02d", picker.hour - 12) + " : " + String.format(
                        "%02d",
                        picker.minute
                    ) + " AM"
            }
            calendar = Calendar.getInstance()
            calendar!![Calendar.HOUR_OF_DAY] = picker.hour
            calendar!![Calendar.MINUTE] = picker.minute
            calendar!![Calendar.SECOND] = 0
            calendar!![Calendar.MILLISECOND] = 0
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name: CharSequence = "channelIdReminderChannel"
            val description = "Channel for Alarm Manager"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel("channelId", name, importance)
            channel.description = description
            val notificationManager = requireActivity().getSystemService(
                NotificationManager::class.java
            )
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun createPendingIntentGetBroadcast(
        context: Context?,
        id: Int,
        intent: Intent?,
        flag: Int
    ): PendingIntent {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            PendingIntent.getBroadcast(context, id, intent!!, PendingIntent.FLAG_IMMUTABLE or flag)
        } else {
            PendingIntent.getBroadcast(context, id, intent!!, flag)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}