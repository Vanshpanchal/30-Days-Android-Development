package com.example.day24

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var myrecyclerView: RecyclerView
    private lateinit var newlist: ArrayList<news>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myrecyclerView = findViewById(R.id.Recyler)
        val headingArray = arrayOf(
            "Nvidia brings its AI computing platform to cloud data firm Snowflake",
            "Tesla on Autopilot crashes into stopped truck in Pennsylvania -police",
            "Why Big Tech Is Making a Big Play for Live Sports",
            "Bitcoin hits more than 1-year high amid BlackRock ETF excitement",
            "Meta launches Quest+ subscription for VR headsets",
            "Indictment details plan to steal Samsung secrets for Foxconn China project"
        )

        val imgsource = arrayOf(
            R.drawable.img0,
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5
        )

        val newstime = arrayOf("12:45 PM", "4:12 PM", "6:00 AM", "3:41 PM", "5:20 PM", "11:50 AM")
//        val newstime = arrayOf("12:45 PM")
        myrecyclerView.layoutManager = LinearLayoutManager(this)

        newlist = arrayListOf()

        for (index in imgsource.indices) {
            var new = news(headingArray[index], newstime[index], imgsource[index])
            newlist.add(new)
        }

        myrecyclerView.adapter = Myadapter(newlist,this)


    }
}