package com.example.day28

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.day28.ui.login.LoginFragment
import com.google.android.gms.maps.MapFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replace(clock())

        val btnClock = findViewById<Button>(R.id.clock)
        btnClock.setOnClickListener {
            replace(clock())
        }

        val btnSetting = findViewById<Button>(R.id.setting)
        btnSetting.setOnClickListener {
            replace(SettingsFragment())
        }

        val btnValidate = findViewById<Button>(R.id.Validate)
        btnValidate.setOnClickListener {
            replace(LoginFragment())
        }
    }

    private fun replace(frag: Fragment) {
        val fragManager = supportFragmentManager
        val fragmentTransaction = fragManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, frag)
        fragmentTransaction.commit()
    }
}