package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var pref: SharedPreferences

    private val APP_PREFERENCES = "mysettings"
    private val APP_PREFERNCES_COUNT = "count"
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "SharedPreferences"

        pref = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)

        button.setOnClickListener(){
            counter++
            text.setText("Я насчитал $counter ворон")
        }
    }

    override fun onPause() {
        super.onPause()

        val editor = pref.edit()
        editor.putInt(APP_PREFERNCES_COUNT,counter)
        editor.apply()
    }

    override fun onResume() {
        super.onResume()

        if (pref.contains(APP_PREFERNCES_COUNT)){
            counter = pref.getInt(APP_PREFERNCES_COUNT,0)
            text.setText("Я насчитал $counter ворон")
        }
    }
}
