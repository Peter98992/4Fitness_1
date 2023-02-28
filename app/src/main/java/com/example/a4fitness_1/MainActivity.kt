package com.example.a4fitness_1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //OPEN ACTIVITIES

        //OPENS SETTINGS ACTIVITY
        val settingsImageView = findViewById<ImageView>(R.id.image_settings)

        settingsImageView.setOnClickListener {
            val intentForSettings = Intent(this, activity_settings::class.java)
            startActivity(intentForSettings)
        }

        //OPENS CALORIES ACTIVITY
        val cardCalories = findViewById<CardView>(R.id.card_calories)

        cardCalories.setOnClickListener {
            val intentForCardCalories = Intent(this, activity_calories::class.java)
            startActivity(intentForCardCalories)
        }
    }

    // Do nothing when back is pressed
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        // do nothing
    }
}