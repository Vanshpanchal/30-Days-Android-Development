package com.example.day6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var klogo = findViewById<ImageView>(R.id.kotlin)
        var slogo = findViewById<ImageView>(R.id.swift)
        var flogo = findViewById<ImageView>(R.id.flutter)

        klogo.setOnClickListener {
            var Kintent = Intent(this,kotlin::class.java)
            startActivity(Kintent)
        }

        slogo.setOnClickListener {
            var Sintent = Intent(this,swift::class.java)
            startActivity(Sintent)
        }

        flogo.setOnClickListener {
            var Fintent = Intent(this,flutter::class.java)
            startActivity(Fintent)
        }
    }

}