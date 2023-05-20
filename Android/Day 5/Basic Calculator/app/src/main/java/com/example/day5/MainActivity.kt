package com.example.day5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {
// DECLARATION

    private var tvInput: TextView? = null
    var numeric: Boolean = false;
    var lastdecimal: Boolean = false
    var decimalcount: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// START
        tvInput = findViewById(R.id.tv_input)

    }

    fun onDigit(view: View) {
        tvInput?.append((view as Button).text)
        numeric = true;
        lastdecimal = false;
    }

    fun onClr(view: View) {
        tvInput?.text = ""
        decimalcount = 0
    }

    fun onEqual(view: View) {

        if (numeric) {
            var tvValue = tvInput?.text.toString()
            var prefix = ""
            if (tvValue.contains("-")) {

                try {
                    if (tvValue.startsWith("-")) {
                        prefix = "-"
                        tvValue = tvValue.substring(1)
                    }
                    var splitvalue = tvValue.split("-")

                    var one = splitvalue[0]
                    var two = splitvalue[1]


                    if (prefix.isNotEmpty()) {
                        one = prefix + one
                    }
                    var result = one.toDouble() - two.toDouble()
                    tvInput?.text = result.toString()

                } catch (e: ArithmeticException) {
                    e.printStackTrace()
                }
            }

            if (tvValue.contains('+')) {
                var splitvalue = tvValue.split("+")

                var one = splitvalue[0].toDouble()
                var two = splitvalue[1].toDouble()

                tvInput?.text = (one + two).toString()
            }

            if (tvValue.contains('/')) {
                var splitvalue = tvValue.split("/")

                var one = splitvalue[0].toDouble()
                var two = splitvalue[1].toDouble()

                tvInput?.text = (one / two).toString()
            }

            if (tvValue.contains('%')) {
                var splitvalue = tvValue.split("%")

                var one = splitvalue[0].toDouble()
                var two = splitvalue[1].toDouble()

                tvInput?.text = (one % two).toString()
            }

            if (tvValue.contains('X')) {
                var splitvalue = tvValue.split("X")

                var one = splitvalue[0].toDouble()
                var two = splitvalue[1].toDouble()

                tvInput?.text = (one * two).toString()
            }
        }


    }

    fun onDecimal(view: View) {
        var plus = tvInput?.text.toString().contains("+")
        var minus = tvInput?.text.toString().contains("-")
        var div = tvInput?.text.toString().contains("/")
        var mod = tvInput?.text.toString().contains("%")
        var multiply = tvInput?.text.toString().contains("X")
//        if (!plus || !minus || !div || !mod || multiply) {
        if (decimalcount == 0 && numeric) {

            if (numeric && !lastdecimal) {
                tvInput?.append(".")
                decimalcount += 1
            }
        } else {
//            tvInput?.append("ERROR")
        }
    }
//    }

//    fun operation(view: View) :Boolean {
//        var plus = tvInput?.text.toString().contains("+")
//        var minus = tvInput?.text.toString().contains("-")
//        var div = tvInput?.text.toString().contains("/")
//        var mod = tvInput?.text.toString().contains("%")
//        var multiply = tvInput?.text.toString().contains("X")
//
//       return plus || minus || div || mod || multiply
//    }

    fun operation(view: View) {
        tvInput?.text?.let {

            if (numeric && !operatoraddded(tvInput?.text.toString())) {
                tvInput?.append((view as Button).text)
            }
        }
    }

    fun operatoraddded(value: String): Boolean {
        return if (value.startsWith("-")) {
            false
        } else {
            value.contains("-") || value.contains("+")
                    || value.contains("/") || value.contains("%") ||
                    value.contains("X")
        }
//            false
    }
}