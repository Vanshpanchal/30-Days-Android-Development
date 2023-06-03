package com.example.day6

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class flutter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flutter)

        var weblink = findViewById<TextView>(R.id.textView2)

        weblink.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW)
         intent.data = Uri.parse("https://dart.dev/")
            startActivity(intent)
        }
    }
}