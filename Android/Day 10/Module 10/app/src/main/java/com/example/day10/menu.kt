package com.example.day10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class menu : AppCompatActivity() {

    companion object{
        const val KEY1 = "one"
        const val KEY2 = "two"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var spbtn = findViewById<Spinner>(R.id.spin)
        var spbtn2 = findViewById<Spinner>(R.id.spin2)
        var submit = findViewById<Button>(R.id.submit)

        var coffee: String = "";
        var snacks: String = "";

        spbtn.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                coffee = parent?.getItemAtPosition(position).toString();
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        spbtn2.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                snacks = parent?.getItemAtPosition(position).toString();
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        submit.setOnClickListener {
//            Toast.makeText(this, "$coffee \n $snacks ", Toast.LENGTH_SHORT).show()
            intent = Intent(this, order::class.java)
            intent.putExtra(KEY1, coffee)
            intent.putExtra(KEY2, snacks )
            startActivity(intent)
        }

    }
}