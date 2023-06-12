package com.example.day11

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)



        val uname = intent.getStringExtra("uname")
        val home = findViewById<ConstraintLayout>(R.id.home)

        val one = Snackbar.make(home, " 🎗️ Welcome $uname 🎗️", Snackbar.LENGTH_LONG)
        one.setTextColor((Color.parseColor("#FFD14F")))
        one.setBackgroundTint(Color.parseColor("#080202"))
        one.animationMode = Snackbar.ANIMATION_MODE_SLIDE
        one.setActionTextColor(Color.parseColor("#FFFFFF"))
        one.setAction("OK") {
            one.dismiss()
        }
        one.show()
    }
}