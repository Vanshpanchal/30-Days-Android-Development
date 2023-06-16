package com.example.day11

import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class home : AppCompatActivity() {
    lateinit var preferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var btn = findViewById<FloatingActionButton>(R.id.button)

        btn.setOnClickListener {
            preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
            editor = preferences.edit()
            editor.clear()
            editor.commit()

            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        val uname = intent.getStringExtra("uname")




        val name = intent.getStringExtra("name")
        val home = findViewById<ConstraintLayout>(R.id.home)
        if (uname == null) {
            val one = Snackbar.make(home, " 🎗️ Welcome $name 🎗️", Snackbar.LENGTH_LONG)
            one.setTextColor((Color.parseColor("#FFD14F")))
            one.setBackgroundTint(Color.parseColor("#080202"))
            one.animationMode = Snackbar.ANIMATION_MODE_SLIDE
            one.setActionTextColor(Color.parseColor("#FFFFFF"))
            one.setAction("OK") {
                one.dismiss()
            }
            one.show()
            var welcome = findViewById<TextView>(R.id.welcome)
            welcome.append("\n${name}")
        } else {


            val one = Snackbar.make(home, " 🎗️ Welcome $uname 🎗️", Snackbar.LENGTH_LONG)

            one.setTextColor((Color.parseColor("#FFD14F")))
            one.setBackgroundTint(Color.parseColor("#080202"))
            one.animationMode = Snackbar.ANIMATION_MODE_SLIDE
            one.setActionTextColor(Color.parseColor("#FFFFFF"))
            one.setAction("OK") {
                one.dismiss()
            }
            one.show()
            var welcome = findViewById<TextView>(R.id.welcome)
            welcome.append("\n${uname}")
        }
    }
}