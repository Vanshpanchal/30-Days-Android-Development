package com.example.day22part2

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class Userprofile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userprofile)

        val uname = intent.getStringExtra("name")
        val phn = intent.getStringExtra("phone")
        val Imgid = intent.getIntExtra("ImgId", R.drawable.def)

        val nameTV = findViewById<TextView>(R.id.name)
        val PhnTV = findViewById<TextView>(R.id.phone)
        val greetTV = findViewById<TextView>(R.id.greet)
        val profileIV = findViewById<ImageView>(R.id.profile)

        nameTV.text = "Name: $uname"
        PhnTV.text = "Phone:$phn"
        greetTV.text = "$uname's PROFILE"
        profileIV.setImageResource(Imgid)

        val callbtn = findViewById<Button>(R.id.call)

        callbtn.setOnClickListener {

            val i = Intent(Intent.ACTION_DIAL)
            i.data = Uri.parse("tel:$phn")
            startActivity(i)
        }
    }
}