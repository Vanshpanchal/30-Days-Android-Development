package com.example.day22part2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var userlist: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listview = findViewById<ListView>(R.id.List)

        var name = arrayOf("Person 1", "Person 2", "Person 3", "Person 4", "Person 5")
        var msg = arrayOf("Hello", "Ola", "How r u?", "Done", "Hey!")
        var msgtime = arrayOf("8:10 AM", "8:12 AM", "5:10 PM", "6:05 PM", "8:10 PM")
        var phoneNo = arrayOf("1111111111", "2222222222", "3333333333", "4444444444", "5555555555")
        var imgId = arrayOf(
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5
        )

        userlist = ArrayList()

        for (index in name.indices) {
            val user = User(name[index],  msgtime[index],msg[index], phoneNo[index], imgId[index])
            userlist.add(user)
        }

        listview.adapter = Myadapter(this, userlist)


    }
}