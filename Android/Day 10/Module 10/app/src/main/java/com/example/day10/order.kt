package com.example.day10

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.security.keystore.StrongBoxUnavailableException
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.TextView

class order : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val Sbox = intent.getStringExtra(menu.KEY1)
        val Cbox = intent.getStringExtra(menu.KEY2)

        var coffee = findViewById<TextView>(R.id.coffee_detail)
        var snack = findViewById<TextView>(R.id.snacks_detail)

        coffee.text = Sbox.toString()
        snack.text = Cbox.toString()


    }
}