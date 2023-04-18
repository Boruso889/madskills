package com.example.madskills

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class RegActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)
        val ConReg: TextView = findViewById(R.id.ConReg)
        val emailReg: TextView = findViewById(R.id.emailReg)
        ConReg.setOnClickListener {
            if(emailReg.text.isEmpty()){
                Toast.makeText(this@RegActivity, "Не все поля заполнены." , Toast.LENGTH_LONG).show()

            }
            if(!emailReg.text.contains("@")){
                Toast.makeText(this@RegActivity, "Неправильно указана почта." , Toast.LENGTH_LONG).show()

            } else {
                val intent = Intent(this@RegActivity, CardActivity::class.java)
                startActivity(intent)
                this@RegActivity.finish()
            }
            }
    }
}