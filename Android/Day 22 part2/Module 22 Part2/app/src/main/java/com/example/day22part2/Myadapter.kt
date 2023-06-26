package com.example.day22part2

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class Myadapter(var context: Activity, var list: ArrayList<User>) :
    ArrayAdapter<User>(context, R.layout.design, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.design, null)

        val img = view.findViewById<CircleImageView>(R.id.profile_image)
        val msg = view.findViewById<TextView>(R.id.msg)
        val msgtime = view.findViewById<TextView>(R.id.time)
        val name = view.findViewById<TextView>(R.id.person)

        name.text = list[position].name
        msg.text = list[position].msg
        msgtime.text = list[position].time
        img.setImageResource(list[position].imgId)


        return view
    }
}