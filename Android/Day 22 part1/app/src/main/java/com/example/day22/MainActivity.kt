package com.example.day22

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import com.example.day22.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.*
import com.google.android.material.snackbar.Snackbar.make
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val Listoftask = arrayListOf<String>()
        Listoftask.add("Getting dressed")
        Listoftask.add("Checking emails or messages")
        Listoftask.add("Attending meetings or classes")
        Listoftask.add("Taking a walk or stretching")
        Listoftask.add("Relaxing or watching TV")

        val listView = findViewById<ListView>(R.id.Listview)

        val Myadapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, Listoftask)
        listView.adapter = Myadapter

        listView.setOnItemClickListener { parent, viewone, position, id ->

            val msg = "Task : ${(viewone as TextView).text}"
            val bar =
                make(bind.root, msg, Snackbar.LENGTH_SHORT)
            bar.setBackgroundTint(Color.parseColor("#000000"))
            bar.setActionTextColor(Color.parseColor("#FFFFFF"))
            bar.setAction("OK", View.OnClickListener {
                bar.dismiss()
            })
            bar.show()
        }


    }


}