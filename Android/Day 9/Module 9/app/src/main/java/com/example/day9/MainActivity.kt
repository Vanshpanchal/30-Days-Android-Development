package com.example.day9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startbtn = findViewById<Button>(R.id.sbtn)

        startbtn.setOnClickListener {
            intent = Intent(this,Activity2::class.java)
            startActivity(intent)
        }
    }


}