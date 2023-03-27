package com.example.a4fitness_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class start_page : AppCompatActivity() {

    private lateinit var dbHelper: starting_databasehelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_page)


        val buttonContinue = findViewById<TextView>(R.id.textView_Continue)
        val inputName = findViewById<EditText>(R.id.input_name)
        val inputCurrentKg = findViewById<EditText>(R.id.input_baseKg)
        val inputGoalKg = findViewById<EditText>(R.id.input_goalKg)

        dbHelper = starting_databasehelper(this)
        val db = dbHelper


        buttonContinue.setOnClickListener {



        }





    }
}