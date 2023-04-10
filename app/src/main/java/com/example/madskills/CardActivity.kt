package com.example.madskills

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class CardActivity : AppCompatActivity() {
    val genders = resources.getStringArray(R.array.Gender)
    val spinner: Spinner = findViewById(R.id.spinner)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)
        val tvCardSkip: TextView = findViewById(R.id.tvCardSkip)
        tvCardSkip.setOnClickListener {
            val intent = Intent(this@CardActivity, MainActivity2::class.java)
            startActivity(intent)
            this@CardActivity.onPause()
        }
        val spinner = findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, genders
            )
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    Toast.makeText(
                        this@CardActivity,
                        getString(R.string.selected_item) + " " +
                                "" + genders[position], Toast.LENGTH_SHORT
                    ).show()

                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }
            }
        }
    }
}