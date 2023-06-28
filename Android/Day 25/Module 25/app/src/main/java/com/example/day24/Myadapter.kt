package com.example.day24

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import javax.xml.transform.ErrorListener

class Myadapter(var newslist: ArrayList<news>, var context: Activity) :
    RecyclerView.Adapter<Myadapter.Myviewholder>() {

    lateinit var mylistener: onitemclick

    interface onitemclick {
        fun itemclicklistener(position: Int)
    }

    fun onitem(listener: onitemclick) {
        mylistener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewholder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)
        return Myviewholder(itemView, mylistener)
    }

    override fun getItemCount(): Int {
        return newslist.size
    }

    override fun onBindViewHolder(holder: Myviewholder, position: Int) {
        val currentInstances = newslist[position]
        holder.heading.text = currentInstances.heading
        holder.img.setImageResource(currentInstances.imgID)
        holder.time.text = currentInstances.time
    }




    class Myviewholder(itemView: View, listener: onitemclick) : RecyclerView.ViewHolder(itemView) {
        val heading = itemView.findViewById<TextView>(R.id.heading)
        val img =
            itemView.findViewById<de.hdodenhof.circleimageview.CircleImageView>(R.id.headingimg)
        val time = itemView.findViewById<TextView>(R.id.newstime)

        init {
            itemView.setOnClickListener{

                listener.itemclicklistener(adapterPosition)
            }
        }
    }
}