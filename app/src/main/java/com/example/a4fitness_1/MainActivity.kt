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

        //OPENS DIET IDEAS ACTIVITY
        val cardDietIdeas = findViewById<CardView>(R.id.card_diet)

        cardDietIdeas.setOnClickListener {
            val intentForDietIdeas = Intent(this, activity_webview_recepies::class.java)
            startActivity(intentForDietIdeas)
        }

        //OPENS ARTICLES ACTIVITY
        val cardArticles = findViewById<CardView>(R.id.card_articles)

        cardArticles.setOnClickListener {
            val intentForCardArticles = Intent(this, activity_webview_articles::class.java)
            startActivity(intentForCardArticles)
        }

        //OPENS QUIZZ ACTIVITY
        val cardQuizz = findViewById<CardView>(R.id.card_quizz)

        cardQuizz.setOnClickListener {
            val intentForCardQuizz = Intent(this, activity_quizz_main::class.java)
            startActivity(intentForCardQuizz)
        }

    }

    // Do nothing when back is pressed
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        // do nothing
    }
}