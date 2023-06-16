package com.example.day11

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.math.sign

class MainActivity : AppCompatActivity() {
    lateinit var preferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        editor = preferences.edit()
        if (preferences.contains("unamepref") && preferences.contains("pass")) {
            intent = Intent(this, home::class.java)
            val name =  preferences.getString("unamepref","").toString()
            intent.putExtra("name", name)
            startActivity(intent)
        }

        val signin_btn = findViewById<Button>(R.id.sign_in)
        val signupbtn = findViewById<TextView>(R.id.sing_up)

        signin_btn.setOnClickListener {
            intent = Intent(this, signin::class.java)
            startActivity(intent)
        }

        signupbtn.setOnClickListener {
            intent = Intent(this, signup::class.java)
            startActivity(intent)
        }
    }
}

