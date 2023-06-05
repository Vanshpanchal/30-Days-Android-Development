package com.example.day9

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class cyber : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cyber)

        val webbtn = findViewById<Button>(R.id.website)

        webbtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.kaspersky.co.in/resource-center/definitions/what-is-cyber-security")
            startActivity(intent)
        }
    }
}