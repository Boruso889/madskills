package com.example.madskills

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)
        val tvCardSkip: TextView = findViewById(R.id.tvCardSkip)
        tvCardSkip.setOnClickListener {
            val intent = Intent(this@CardActivity, MainActivity2::class.java)
            startActivity(intent)
            this@CardActivity.onPause()
        }


    }



}