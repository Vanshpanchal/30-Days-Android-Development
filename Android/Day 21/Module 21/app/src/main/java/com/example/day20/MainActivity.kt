package com.example.day20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.day20.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding
    var currentImg = 0
    lateinit var image: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val name  = arrayOf("Sundar Pichai", "Tim Cook", "Mark Zuckerberg", "Elon Musk")
        val next = bind.next
        val back = bind.back

        back.setOnClickListener {
            val Idofcurrent = "pic${currentImg}"
            val IdofcurrenttoInt = this.resources.getIdentifier(Idofcurrent, "id", packageName)
            image = findViewById(IdofcurrenttoInt)
            image.alpha = 0f

            currentImg = (4 + currentImg - 1) % 4

            val Idofshow = "pic${currentImg}"
            val IdofshowtoInt = this.resources.getIdentifier(Idofshow, "id", packageName)
            image = findViewById(IdofshowtoInt)
            image.alpha = 1f
            bind.name.text = name[currentImg]
        }

        next.setOnClickListener{
            val Idofcurrent = "pic${currentImg}"
            val IdofcurrenttoInt = this.resources.getIdentifier(Idofcurrent, "id", packageName)
            image = findViewById(IdofcurrenttoInt)
            image.alpha = 0f

            currentImg = (4 + currentImg + 1) % 4

            val Idofshow = "pic${currentImg}"
            val IdofshowtoInt = this.resources.getIdentifier(Idofshow, "id", packageName)
            image = findViewById(IdofshowtoInt)
            image.alpha = 1f
            bind.name.text = name[currentImg]
        }
    }
}