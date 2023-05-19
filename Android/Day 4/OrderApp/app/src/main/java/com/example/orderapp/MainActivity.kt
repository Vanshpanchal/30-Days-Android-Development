package com.example.orderapp

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var food = findViewById<RadioGroup>(R.id.radioGroup)
        var vadapav = findViewById<RadioButton>(R.id.Rvadapav)
        var frankie = findViewById<RadioButton>(R.id.Rfrankie)

        var butter = findViewById<CheckBox>(R.id.butter)
        var cheese = findViewById<CheckBox>(R.id.cheese)

        val done = findViewById<Button>(R.id.submit)

        done.setOnClickListener() {

            var detail = ""
            var V = vadapav.isChecked
            var F = frankie.isChecked

            if (V || F) {
                if (V) {
                    detail = "Vadapav"
                } else {
                    detail = "Frankie"
                }

                var B = butter.isChecked
                var C = cheese.isChecked

                if (B && C) {
                    detail += " with Butter & Cheese"
                } else if (B && !C) {
                    detail += " with Butter "
                } else if (!B && C) {
                    detail += " with Oil & Cheese"
                } else {
                    detail += " with Oil"
                }
                Toast.makeText(this, detail, Toast.LENGTH_SHORT).show()

            }
            else {
                var view: View = findViewById(R.id.main)

                    Toast.makeText(this, "Select atleast one Food", Toast.LENGTH_SHORT).show()


            }
        }
    }

}



