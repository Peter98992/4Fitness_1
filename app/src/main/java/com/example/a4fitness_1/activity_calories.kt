package com.example.a4fitness_1

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.a4fitness_1.DialogChangeCurrentKG.KGDialogListener

class activity_calories : AppCompatActivity(), KGDialogListener {

    private var textViewCurrentKgValue: TextView? = null
    private var buttonCurrentKg: ImageView? = null
    private var textViewGoalKgValue: TextView? = null
    private var buttonSetWeight: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calories)

        //CHANGE CURRENT KG
        textViewCurrentKgValue = findViewById<View>(R.id.KgTextView) as TextView

        buttonCurrentKg = findViewById(R.id.changeWeightImageView)
        buttonCurrentKg!!.setOnClickListener { openDialogCurrentKg() }

        // Change Goal KG
        textViewGoalKgValue = findViewById<View>(R.id.KGBUTTONTEST) as TextView?
        buttonSetWeight = findViewById(R.id.setWeightButton)
        buttonSetWeight!!.setOnClickListener { openDialogGoalKg() }
    }


    // Functions for changing current KG
    private fun openDialogCurrentKg() {
        val dialogChangeCurrentKG = DialogChangeCurrentKG()
        dialogChangeCurrentKG.show(supportFragmentManager, "Change KG Dialog")
    }

    override fun applyTextsCurrentKg(value: String?) {
        textViewCurrentKgValue!!.text = value
    }

    // Functions for changing goal KG
    private fun openDialogGoalKg() {
        val dialogChangeGoalKG = DialogChangeGoalKG()
        dialogChangeGoalKG.show(supportFragmentManager, "Change KGs Dialog")
    }

    fun applyTextsGoalKg(valuekg: String?) {
        textViewGoalKgValue!!.text = valuekg
    }
}

