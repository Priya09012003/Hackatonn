package com.example.hackaton

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {

    private lateinit var btnHistory: AppCompatButton // Change to AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnHistory = findViewById<AppCompatButton>(R.id.btnHistory) // Change the casting here

        btnHistory.setOnClickListener{
            val intent = Intent(this, BookingHistory::class.java)
            startActivity(intent)
        }
    }
}

