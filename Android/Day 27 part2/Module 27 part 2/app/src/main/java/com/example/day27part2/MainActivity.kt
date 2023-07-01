package com.example.day27part2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceWithFragment(home())
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.BNV)

        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    replaceWithFragment(home())
                }

                R.id.mail -> {
                    replaceWithFragment(mail())
                }

                R.id.profile -> {
                    replaceWithFragment(profile())
                }
            }
            true
        }

    }

    private fun replaceWithFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        FragmentTransaction.TRANSIT_ENTER_MASK
        fragmentTransaction.replace(R.id.Frame, fragment)
        fragmentTransaction.commit()

    }


}