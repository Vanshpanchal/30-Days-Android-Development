package com.example.day11

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.android.material.snackbar.Snackbar.*

class signin : AppCompatActivity() {
    lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val back = findViewById<LinearLayout>(R.id.b_sign_in)
        val main_id = findViewById<ConstraintLayout>(R.id.layout_two)


        back.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val username = findViewById<TextInputEditText>(R.id.sigin_username)
        val pass = findViewById<TextInputEditText>(R.id.signin_password)
        val signinbtn = findViewById<Button>(R.id.login)

        signinbtn.setOnClickListener {


            val uname = username.text.toString()
            val password = pass.text.toString()

            if (uname.isNotEmpty() && password.isNotEmpty() && !uname.isNullOrBlank() && !password.isNullOrBlank()) {
                readData(uname, password)

            } else {
//                Toast.makeText(this, "please enter all details ", Toast.LENGTH_SHORT).show()
                val one =
                    Snackbar.make(main_id, "Please Enter All Details", Snackbar.LENGTH_SHORT)
                one.setBackgroundTint(Color.parseColor("#080202"))
                one.animationMode = ANIMATION_MODE_SLIDE
                one.setTextColor((Color.parseColor("#B70404")))
                one.setActionTextColor(Color.parseColor("#FFFFFF"))
                one.setAction("OK") {
                    one.dismiss()
                }
                one.show()

            }
        }
    }


    private fun readData(uname: String, password: String) {

        val main_id = findViewById<ConstraintLayout>(R.id.layout_two)
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        databaseReference.child(uname).get().addOnSuccessListener {
            if (it.exists()) {
                val pass = it.child("password").value

                if (password == pass) {
//                    Toast.makeText(this, "Hurry!", Toast.LENGTH_SHORT).show()


                    intent = Intent(this, home::class.java)
                    intent.putExtra("uname", uname)
                    startActivity(intent)


                } else {
//                    Toast.makeText(this, "password doesn't Match", Toast.LENGTH_SHORT).show()
                    val one = Snackbar.make(
                        main_id,
                        "Incorrect Password / Username",
                        Snackbar.LENGTH_SHORT
                    )
                    one.setTextColor((Color.parseColor("#B70404")))
                    one.setBackgroundTint(Color.parseColor("#080202"))
                    one.animationMode = ANIMATION_MODE_SLIDE
                    one.setActionTextColor(Color.parseColor("#FFFFFF"))
                    one.setAction("OK") {
                        one.dismiss()
                    }
                    one.show()
                }


            } else {
//                Toast.makeText(this, "User doesn't exist", Toast.LENGTH_SHORT).show()
                val one =
                    Snackbar.make(main_id, "Incorrect Password / Username", Snackbar.LENGTH_SHORT)
                one.setBackgroundTint(Color.parseColor("#080202"))
                one.setTextColor((Color.parseColor("#B70404")))
                one.animationMode = ANIMATION_MODE_SLIDE
                one.setActionTextColor(Color.parseColor("#FFFFFF"))
                one.setAction("OK") {
                    one.dismiss()
                }
                one.show()
            }
        }.addOnFailureListener {
//            Toast.makeText(this, "Opps!", Toast.LENGTH_SHORT).show()

            val one = Snackbar.make(main_id, "Opps", Snackbar.LENGTH_SHORT)
            one.setBackgroundTint(Color.parseColor("#080202"))
            one.animationMode = ANIMATION_MODE_SLIDE
            one.setTextColor((Color.parseColor("#B70404")))
            one.setActionTextColor(Color.parseColor("#FFFFFF"))
            one.setAction("OK") {
                one.dismiss()
            }
            one.show()
        }
    }
}

