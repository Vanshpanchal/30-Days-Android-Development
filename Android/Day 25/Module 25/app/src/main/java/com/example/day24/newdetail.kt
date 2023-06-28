package com.example.day24

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class newdetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newdetail)

        val heading = intent.getStringExtra("heading")
        val time = intent.getStringExtra("time")
        val imgID = intent.getIntExtra("img", R.drawable.img0)
        val newscontent = intent.getIntExtra("news content", R.string.content0)

        val newimg = findViewById<ImageView>(R.id.imageView)
        newimg.setImageResource(imgID)

        val content = findViewById<TextView>(R.id.newscontent)
        content.setText(newscontent)

        val newsheading = findViewById<TextView>(R.id.textView2) // heading
        newsheading.text = heading
    }
}