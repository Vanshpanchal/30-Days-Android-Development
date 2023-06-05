package com.example.day9


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val callus = findViewById<Button>(R.id.callbtn)

        callus.setOnClickListener {
            val phoneNumber = "1234567890"
            val ph = Uri.parse("tel:$phoneNumber")
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = ph
            startActivity(intent)
        }

        val androidbox = findViewById<ImageView>(R.id.androidbox)
        androidbox.setOnClickListener{
            intent = Intent(this, android_dev::class.java)
            startActivity(intent)
        }

        val webbox = findViewById<ImageView>(R.id.web_box)
        webbox.setOnClickListener{
            intent = Intent(this, web::class.java)
            startActivity(intent)
        }

        val iosbox = findViewById<ImageView>(R.id.ios)
        iosbox.setOnClickListener{
            intent = Intent(this, ios::class.java)
            startActivity(intent)
        }

        val blockchainbox = findViewById<ImageView>(R.id.blockchain)
        blockchainbox.setOnClickListener{
            intent = Intent(this, blockchain::class.java)
            startActivity(intent)
        }

        val cyberbox = findViewById<ImageView>(R.id.cyber)
        cyberbox.setOnClickListener{
            intent = Intent(this, cyber::class.java)
            startActivity(intent)
        }

        val aibox = findViewById<ImageView>(R.id.aibox)
        aibox.setOnClickListener{
            intent = Intent(this, Ai::class.java)
            startActivity(intent)
        }
    }
}