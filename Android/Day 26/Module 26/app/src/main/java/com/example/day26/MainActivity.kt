package com.example.day26

import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Converter
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    lateinit var recycler: RecyclerView
    lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler = findViewById(R.id.recycle)

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getProductData()
        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {

                val response = response.body()
                val productList = response?.products!!
                var sortStatus = false

                if (!sortStatus) {
                    myAdapter = MyAdapter(this@MainActivity, productList)
                    recycler.adapter = myAdapter
                    recycler.layoutManager = LinearLayoutManager(applicationContext)
                }


                val sortbtn = findViewById<ExtendedFloatingActionButton>(R.id.floatingActionButton)

                sortbtn.setOnClickListener {
                    val bottomSheetDialog = BottomSheetDialog(
                        this@MainActivity
                    )

                    val bottomsheView = LayoutInflater.from(applicationContext).inflate(
                        R.layout.dialog,
                        findViewById<LinearLayout>(R.id.bottomsheet)
                    )

                    val pricemin = bottomsheView.findViewById<RadioButton>(R.id.pricemin)

                    pricemin.setOnClickListener {
//                        Toast.makeText(this@MainActivity, "price min", Toast.LENGTH_SHORT).show()
                        val sortedList = productList.sortedByDescending {
                            it.price
                        }
                        myAdapter = MyAdapter(this@MainActivity, sortedList.reversed())
                        recycler.adapter = myAdapter
                        recycler.layoutManager = LinearLayoutManager(applicationContext)
                        bottomSheetDialog.dismiss()
                    }

                    val pricemax = bottomsheView.findViewById<RadioButton>(R.id.pricemax)

                    pricemax.setOnClickListener {
//                        Toast.makeText(this@MainActivity, "price max", Toast.LENGTH_SHORT).show()
                        val sortedList = productList.sortedByDescending {
                            it.price
                        }
                        myAdapter = MyAdapter(this@MainActivity, sortedList)
                        recycler.adapter = myAdapter
                        recycler.layoutManager = LinearLayoutManager(applicationContext)
                        bottomSheetDialog.dismiss()
                    }

                    val ratingmin = bottomsheView.findViewById<RadioButton>(R.id.ratingmin)

                    ratingmin.setOnClickListener {
//                        Toast.makeText(this@MainActivity, "ratingmin", Toast.LENGTH_SHORT).show()
                        val sortedList = productList.sortedByDescending {
                            it.rating
                        }
                        myAdapter = MyAdapter(this@MainActivity, sortedList.reversed())
                        recycler.adapter = myAdapter
                        recycler.layoutManager = LinearLayoutManager(applicationContext)
                        bottomSheetDialog.dismiss()
                    }

                    val ratingmax = bottomsheView.findViewById<RadioButton>(R.id.ratingmax)

                    ratingmax.setOnClickListener {
//                        Toast.makeText(this@MainActivity, "price ratingmax", Toast.LENGTH_SHORT).show()
                        val sortedList = productList.sortedByDescending {
                            it.rating
                        }
                        myAdapter = MyAdapter(this@MainActivity, sortedList)
                        recycler.adapter = myAdapter
                        recycler.layoutManager = LinearLayoutManager(applicationContext)
                        bottomSheetDialog.dismiss()
                    }

                    val clrbtn = bottomsheView.findViewById<Button>(R.id.clear)
                    clrbtn.setOnClickListener {
                        myAdapter = MyAdapter(this@MainActivity, productList)
                        recycler.adapter = myAdapter
                        recycler.layoutManager = LinearLayoutManager(applicationContext)
                        bottomSheetDialog.dismiss()
                    }
                    bottomSheetDialog.setContentView(bottomsheView)
                    bottomSheetDialog.show()
                }
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                Log.d("MainActivity", "onFailure: ${t.message}")
            }
        })

    }
}