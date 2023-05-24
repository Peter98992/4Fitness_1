package com.example.a4fitness_1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class activity_quizz_main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz_main)
        val startbutton = findViewById<View>(R.id.button) as Button
        val aboutbutton = findViewById<View>(R.id.button2) as Button
        startbutton.setOnClickListener {
            val intent = Intent(applicationContext, activity_questions::class.java)
            startActivity(intent)
        }
    }
}
