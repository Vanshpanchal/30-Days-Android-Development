package com.example.day27part1

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private val channelId = "ID"
    private val channelName = "Name"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNotificationChannel()

        val msg = findViewById<EditText>(R.id.msg)

        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_IMMUTABLE
        )

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.cancel(0)

        val btnNotify = findViewById<Button>(R.id.notify)

        btnNotify.setOnClickListener {
            if (!msg.text.isNullOrBlank()) {
                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.POST_NOTIFICATIONS
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    val bar = Snackbar.make(
                        it,
                        "Please Grant Notification Permission",
                        Snackbar.LENGTH_SHORT
                    )
                    bar.setAction("OK") {
                        bar.dismiss()
                    }
                    bar.setActionTextColor(Color.parseColor("#FFFFFF"))
                    bar.show()
                }
                val notification = NotificationCompat.Builder(this, channelId)
                    .setContentTitle("Message📄")
                    .setContentText(msg.text.toString())
                    .setContentIntent(pendingIntent)
                    .setSmallIcon(R.drawable.baseline_message_24)
                    .build()
                notificationManager.notify(0, notification)

            } else {
                val bar = Snackbar.make(
                    it,
                    "Message field should not be empty",
                    Snackbar.LENGTH_SHORT
                )
                bar.setAction("OK") {
                    bar.dismiss()
                }
                bar.setActionTextColor(Color.parseColor("#FFFFFF"))
                bar.show()
            }
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)

            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            notificationManager.createNotificationChannel(channel)
        }
    }


}