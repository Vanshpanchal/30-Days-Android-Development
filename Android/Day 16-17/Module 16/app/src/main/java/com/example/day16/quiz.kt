package com.example.day16

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.graphics.Color
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.day16.databinding.ActivityQuizBinding
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT
import com.google.android.material.snackbar.Snackbar
import java.util.Queue

class quiz : AppCompatActivity() {
    lateinit var bind: ActivityQuizBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(bind.root)

        var count = 0
        var Que1 = 0
        var Que2 = 0
        var Que3 = 0
        var result = 0
        bind.Q1.setOnClickListener {
            if (Que1 == 0) {
                val build1 = AlertDialog.Builder(this)
                val option = arrayOf(
                    "They require explicit casting syntax.",
                    "They automatically cast variables based on type checks.",
                    "They allow implicit type conversion."
                )
                var selected = ""
                val Answer = "They automatically cast variables based on type checks."
                build1.setTitle("Which of the following is true about Kotlin's smart casts?")
                build1.setSingleChoiceItems(
                    option,
                    -1,
                    DialogInterface.OnClickListener { dialog, which ->
                        selected = option[which]
                        selected = option[which]
                        count += 1

                    })

                build1.setPositiveButton(
                    "Submit",
                    DialogInterface.OnClickListener { dialog, which ->

                        if (selected == Answer) {
                            bind.Q1.setBackgroundResource(R.drawable.correct)

                            val text = bind.Q1.text.toString()
                            bind.Q1.setTextColor(ContextCompat.getColor(this, R.color.white))
                            val status = "$text ✅"
                            bind.Q1.text = status
                            result += 1
                        } else {
                            bind.Q1.setBackgroundResource(R.drawable.incorrect)
                            bind.Q1.setTextColor(ContextCompat.getColor(this, R.color.white))
                            val text = bind.Q1.text.toString()
                            val status = "$text ❌"
                            bind.Q1.text = status
                            result += 0
                        }
                        Que1 = 1
                        bind.attempt.text = "3/1"
                        bind.Q2.visibility = View.VISIBLE
                    })


                build1.setNegativeButton("NO", DialogInterface.OnClickListener { dialog, which -> })


//                val alertDialog = build1.create()
                build1.show()

            } else {
                var snack =
                    Snackbar.make(bind.root, "You Can't Alter Your Submission", LENGTH_SHORT)
                snack.setAction("Ok", View.OnClickListener {
                    snack.dismiss()
                })

                snack.show()
            }
        }
        bind.Q2.setOnClickListener {
            if (Que2 == 0) {
                val build1 = AlertDialog.Builder(this)
                val option = arrayOf(
                    "To allow for multiple inheritance",
                    "To provide dynamic typing",
                    "To prevent null pointer exceptions"
                )
                var selected = ""
                val Answer = "To prevent null pointer exceptions"
                build1.setTitle("What is the primary purpose of Kotlin's nullable types?")
                build1.setSingleChoiceItems(
                    option,
                    -1,
                    DialogInterface.OnClickListener { dialog, which ->
                        selected = option[which]
                        selected = option[which]
                        count += 1

                    })

                build1.setPositiveButton(
                    "Submit",
                    DialogInterface.OnClickListener { dialog, which ->

                        if (selected == Answer) {
                            bind.Q2.setBackgroundResource(R.drawable.correct)

                            val text = bind.Q2.text.toString()
                            bind.Q2.setTextColor(ContextCompat.getColor(this, R.color.white))
                            val status = "$text ✅"
                            bind.Q2.text = status
                            result += 1
                        } else {
                            bind.Q2.setBackgroundResource(R.drawable.incorrect)
                            bind.Q2.setTextColor(ContextCompat.getColor(this, R.color.white))
                            val text = bind.Q2.text.toString()
                            val status = "$text ❌"
                            bind.Q2.text = status
                            result += 0
                        }
                        Que2 = 1
                        bind.attempt.text = "3/2"
                        bind.Q3.visibility = View.VISIBLE
//
                    })


                build1.setNegativeButton("NO", DialogInterface.OnClickListener { dialog, which -> })


//                val alertDialog = build1.create()
                build1.show()

            } else {
                var snack =
                    Snackbar.make(bind.root, "You Can't Alter Your Submission", LENGTH_SHORT)
                snack.setAction("Ok", View.OnClickListener {
                    snack.dismiss()
                })

                snack.show()
            }
        }

        bind.Q3.setOnClickListener {
            if (Que3 == 0) {
                val build1 = AlertDialog.Builder(this)
                val option = arrayOf("MongoDB", "MySQL", "SQLite")
                var selected = ""
                val Answer = "MySQL"
                build1.setTitle("Which DBMS is based on the SQL language?")
                build1.setSingleChoiceItems(
                    option,
                    -1,
                    DialogInterface.OnClickListener { dialog, which ->
                        selected = option[which]
                        selected = option[which]
                        count += 1

                    })

                build1.setPositiveButton(
                    "Submit",
                    DialogInterface.OnClickListener { dialog, which ->

                        if (selected == Answer) {
//                            Toast.makeText(this, "One", Toast.LENGTH_SHORT).show()
                            bind.Q3.setBackgroundResource(R.drawable.correct)

                            val text = bind.Q3.text.toString()
                            bind.Q3.setTextColor(ContextCompat.getColor(this, R.color.white))
                            val status = "$text ✅"
                            bind.Q3.text = status
                            result += 1
                        } else {
//                            Toast.makeText(this, "none", Toast.LENGTH_SHORT).show()
                            bind.Q3.setBackgroundResource(R.drawable.incorrect)
                            bind.Q3.setTextColor(ContextCompat.getColor(this, R.color.white))
                            val text = bind.Q3.text.toString()
                            val status = "$text ❌"
                            bind.Q3.text = status
                            result += 0
                        }
                        Que2 = 1
                        bind.attempt.text = "3/3"
                        bind.result.visibility = View.VISIBLE
//
                    })


                build1.setNegativeButton("NO", DialogInterface.OnClickListener { dialog, which -> })


//                val alertDialog = build1.create()
                build1.show()

            } else {
                var snack =
                    Snackbar.make(bind.root, "You Can't Alter Your Submission", LENGTH_SHORT)

                snack.setAction("Ok", View.OnClickListener {
                    snack.dismiss()
                })

                snack.show()
                bind.result.visibility = View.VISIBLE
            }


        }

        bind.result.setOnClickListener {
            val score = AlertDialog.Builder(this)
            if (result == 0) {

                score.setTitle("You Scored $result out of 3")
                score.setMessage("Better Luck Next Time")
            } else if (result == 1) {

                score.setTitle("You Scored $result out of 3")
                score.setMessage("Well Try")
            } else if (result == 2) {

                score.setTitle("You Scored $result out of 3")
                score.setMessage("Good")
            } else {

                score.setTitle("You Scored $result out of 3")
                score.setMessage("Fab! 👏👏")
            }
            score.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->

            })
            score.show()
        }
    }
}






