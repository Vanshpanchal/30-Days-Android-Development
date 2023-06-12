package com.example.day11

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.android.material.snackbar.Snackbar.*

class signup : AppCompatActivity() {
    lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        val layout_id = findViewById<ConstraintLayout>(R.id.layout_signup)
        val back = findViewById<LinearLayout>(R.id.b_sign_up)
        var sup_uname = findViewById<TextInputEditText>(R.id.signup_username)
        var sup_email = findViewById<TextInputEditText>(R.id.signup_email)
        var sup_pass = findViewById<TextInputEditText>(R.id.signup_password)
        var signup = findViewById<Button>(R.id.signup_btn)



        back.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        signup.setOnClickListener {
            val username = sup_uname.text.toString()
            val email = sup_email.text.toString()
            val password = sup_pass.text.toString()
            val status : Boolean = false
            if (!username.isNullOrBlank() && !email.isNullOrBlank() && !password.isNullOrBlank() && username.length >= 8 && username.length <= 11 && password.length >= 8) {


                database = FirebaseDatabase.getInstance().getReference("Users")
                database.child(username).get().addOnSuccessListener {
                    if (it.exists()) {

                        val one = make(layout_id, "User Already Exists", LENGTH_SHORT)
                        one.setBackgroundTint(Color.parseColor("#080202"))
                        one.animationMode = ANIMATION_MODE_SLIDE
                        one.setTextColor((Color.parseColor("#B70404")))
                        one.setActionTextColor(Color.parseColor("#FFFFFF"))
                        one.setAction("OK") {
                            one.dismiss()
                        }
                        one.show()

                    } else {
                        val user = User(username, email, password)

                        database = FirebaseDatabase.getInstance().getReference("Users")
                        database.child(username).setValue(user).addOnSuccessListener {
                            val one = make(layout_id, "User Registered", LENGTH_SHORT)
                            one.setBackgroundTint(Color.parseColor("#080202"))
                            one.animationMode = ANIMATION_MODE_SLIDE
                            one.setTextColor((Color.parseColor("#B70404")))
                            one.setActionTextColor(Color.parseColor("#FFFFFF"))
                            one.setAction("OK") {
                                one.dismiss()
                            }
                            one.show()
                            intent = Intent(this, home::class.java)
                            intent.putExtra("uname", username)
                            startActivity(intent)
                        }.addOnFailureListener {
//
                            val one =
                                make(layout_id, "‼️Error! Please Try Again", LENGTH_SHORT)
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
            } else {
                val one = make(
                    layout_id,
                    "Make sure that the username and password must contain 8 characters",
                    LENGTH_SHORT
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
        }
    }
}
