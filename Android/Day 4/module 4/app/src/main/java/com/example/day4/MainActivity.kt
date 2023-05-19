package com.example.day4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val download = findViewById<Button>(R.id.btnDownload)
        val upload = findViewById<Button>(R.id.btnUpload)

        download.setOnClickListener {
            Toast.makeText(this, "Downloading....", Toast.LENGTH_SHORT).show()
        }

        upload.setOnClickListener {
            Toast.makeText(this, "Uploading....", Toast.LENGTH_SHORT).show()
        }
    }
}