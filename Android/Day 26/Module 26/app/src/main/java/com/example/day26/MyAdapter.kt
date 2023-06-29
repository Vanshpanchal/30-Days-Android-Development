package com.example.day26

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso
import kotlin.io.path.fileVisitor

class MyAdapter(private var context: Activity, private var productList: List<Product>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentItem = productList[position]
        holder.title.text = currentItem.title
        holder.rating.text = currentItem.rating.toString()
        Picasso.get().load(currentItem.thumbnail).into(holder.img);
        holder.description.text = currentItem.description
        holder.price.text= currentItem.price.toString()


    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var description: TextView
        val rating: TextView
        val img: ShapeableImageView
        val price : TextView

        init {
            title = itemView.findViewById(R.id.title)
            description = itemView.findViewById(R.id.description)
            rating = itemView.findViewById(R.id.rating)
            img = itemView.findViewById(R.id.Pimg)
            price = itemView.findViewById(R.id.price)
        }
    }
}