package com.example.a4fitness_1


import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

class activity_calories : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calories)

        // ----------- CHANGE CURRENT WEIGHT---------------


        val changeKgButton = findViewById<TextView>(R.id.KgTextView)
        val popupView = LayoutInflater.from(this).inflate(R.layout.popup_change_kg, null)
        val popupWindow = PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)


        changeKgButton.setOnClickListener {
            // OPENS POPUP
            popupWindow.isFocusable = true
            popupWindow.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            popupWindow.showAtLocation(findViewById(R.id.KgTextView),Gravity.CENTER, 0, 0)

            popupView.setOnClickListener{
                popupView.findViewById<AppCompatButton>(R.id.enterKgButton).setOnClickListener {
                    popupWindow.dismiss()
                }

            }

        }

        // GETTING THE VIEWS
        val popupViewChangeCurrentKG = LayoutInflater.from(this).inflate(R.layout.popup_change_kg, null)
        val inputChangeCurrentKg = popupViewChangeCurrentKG.findViewById<EditText>(R.id.input_KG)
        val buttonChangeCurrentKg = popupViewChangeCurrentKG.findViewById<AppCompatButton>(R.id.enterKgButton)

        // THE FUNCTION





    }


    // ------------------ POPUP FUNCTIONS ----------------------

    //POPUP TO CHANGE WEIGHT


    private fun changeCurrentKg() {
        val popupViewChangeCurrentKG = LayoutInflater.from(this).inflate(R.layout.popup_change_kg, null)
        val popupWindow = PopupWindow( popupViewChangeCurrentKG, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val inputChangeCurrentKg = popupViewChangeCurrentKG.findViewById<EditText>(R.id.input_KG)
        val currentKgTextView = findViewById<TextView>(R.id.KgTextView)
        popupWindow.dismiss()




    }
}