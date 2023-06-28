package com.example.day24

import android.content.Intent
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

//        val newscontent = arrayOf(
//            getString(R.string.content0),
//            getString(R.string.content1),
//            getString(R.string.content2),
//            getString(R.string.content3),
//            getString(R.string.content4), getString(R.string.content5)
//        )

        val newscontent = arrayOf(
            R.string.content0,
            R.string.content1,
            R.string.content2,
            R.string.content3,
            R.string.content4,
            R.string.content5
        )

        myrecyclerView.layoutManager = LinearLayoutManager(this)

        newlist = arrayListOf()

        for (index in imgsource.indices) {
            var new =
                news(headingArray[index], newstime[index], imgsource[index], newscontent[index])
            newlist.add(new)
        }

        var myadapter = Myadapter(newlist, this)
        myrecyclerView.adapter = myadapter

        myadapter.onitem(object : Myadapter.onitemclick {
            override fun itemclicklistener(position: Int) {
                val intent = Intent(applicationContext, newdetail::class.java)
                intent.putExtra("heading", newlist[position].heading)
                intent.putExtra("img", newlist[position].imgID)
                intent.putExtra("news content", newlist[position].newscontent)
                startActivity(intent)

            }

        })


    }
}