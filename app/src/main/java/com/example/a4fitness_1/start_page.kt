package com.example.a4fitness_1

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class start_page : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_page)


        val buttonContinue = findViewById<TextView>(R.id.textView_Continue)


        buttonContinue.setOnClickListener {
            //DECLARATION
            dbHelper = DatabaseHelper(this)
            val db = dbHelper.writableDatabase

            val inputName = findViewById<EditText>(R.id.input_name)
            val inputCurrentKg = findViewById<EditText>(R.id.input_baseKg)
            val inputGoalKg = findViewById<EditText>(R.id.input_goalKg)
            val name = inputName.text.toString()
            val currentKg = inputCurrentKg.text.toString().toInt()
            val goalKg = inputGoalKg.text.toString().toInt()

            mAuth = FirebaseAuth.getInstance()
            val user = mAuth.currentUser.toString()


                val values = ContentValues().apply {
                    put(DatabaseHelper.COLUMN_NAME, name)
                    put(DatabaseHelper.COLUMN_STARTING_KG, currentKg)
                    put(DatabaseHelper.COLUMN_GOAL_KG, goalKg)
                    put(DatabaseHelper.COLUMN_USER, user)
                }

                val newRowId = db?.insert(DatabaseHelper.TABLE_NAME, null, values)


                Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
                sendUserToNextActivity()

        }





    }
    private fun sendUserToNextActivity() {
        val intentToMainActivity = Intent(this, MainActivity::class.java)
        finish()
        startActivity(intentToMainActivity)
    }
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        // do nothing
    }

}