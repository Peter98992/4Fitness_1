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
import java.util.regex.Pattern
class activity_calories : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calories)

        // ----------- CHANGE CURRENT WEIGHT---------------




        val changeKgButtonView = findViewById<TextView>(R.id.KgTextView)
        val popupViewChangeKG = LayoutInflater.from(this).inflate(R.layout.popup_change_kg, null)
        val popupWindow = PopupWindow(popupViewChangeKG, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val inputKG = popupViewChangeKG.findViewById<EditText>(R.id.input_KG)

        changeKgButtonView.setOnClickListener {
            // OPENS POPUP
            popupWindow.isFocusable = true
            popupWindow.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            popupWindow.showAtLocation(findViewById(R.id.KgTextView),Gravity.CENTER, 0, 0)

            popupViewChangeKG.setOnClickListener{
                popupViewChangeKG.findViewById<AppCompatButton>(R.id.enterKgButton).setOnClickListener {

                    changeKgButtonView.text = inputKG.text.toString()
                    popupWindow.dismiss()


                }

            }

        }

    }

}