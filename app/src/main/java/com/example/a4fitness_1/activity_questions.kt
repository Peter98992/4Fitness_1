package com.example.a4fitness_1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class activity_questions : AppCompatActivity() {
    lateinit var tv: TextView
    lateinit var submitbutton: Button
    lateinit var quitbutton: Button
    lateinit var radio_g: RadioGroup
    lateinit var rb1: RadioButton
    lateinit var rb2: RadioButton
    lateinit var rb3: RadioButton
    lateinit var rb4: RadioButton

    val questions = arrayOf(
        "Which method can be defined only once in a program?",
        "Which of these is not a bitwise operator?",
        "Which keyword is used by a method to refer to the object that invoked it?",
        "Which of these keywords is used to define interfaces in Java?",
        "Which of these access specifiers can be used for an interface?",
        "Which of the following is the correct way of importing an entire package 'pkg'?",
        "What is the return type of Constructors?",
        "Which of the following packages stores all the standard Java classes?",
        "Which of these methods of the String class is used to compare two String objects for their equality?",
        "An expression involving byte, int, and literal numbers is promoted to which of these?"
    )
    val answers = arrayOf(
        "main method",
        "<=",
        "this",
        "interface",
        "public",
        "import pkg.*",
        "None of the mentioned",
        "java",
        "equals()",
        "int"
    )
    val opt = arrayOf(
        "finalize method", "main method", "static method", "private method",
        "&", "&=", "|=", "<=",
        "import", "this", "catch", "abstract",
        "Interface", "interface", "intf", "Intf",
        "public", "protected", "private", "All of the mentioned",
        "Import pkg.", "import pkg.*", "Import pkg.*", "import pkg.",
        "int", "float", "void", "None of the mentioned",
        "lang", "java", "util", "java.packages",
        "equals()", "Equals()", "isequal()", "Isequal()",
        "int", "long", "byte", "float"
    )

    var flag = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        val score = findViewById<View>(R.id.textView4) as TextView
        val textView = findViewById<View>(R.id.DispName) as TextView
        val intent = intent
        val name = intent.getStringExtra("myname")
        textView.text = if (name.isNullOrBlank()) "Hello User" else "Hello $name"

        submitbutton = findViewById<View>(R.id.button3) as Button
        quitbutton = findViewById<View>(R.id.buttonquit) as Button
        tv = findViewById<View>(R.id.tvque) as TextView
        radio_g = findViewById<View>(R.id.answersgrp) as RadioGroup
        rb1 = findViewById<View>(R.id.radioButton) as RadioButton
        rb2 = findViewById<View>(R.id.radioButton2) as RadioButton
        rb3 = findViewById<View>(R.id.radioButton3) as RadioButton
        rb4 = findViewById<View>(R.id.radioButton4) as RadioButton

        tv.text = questions[flag]
        rb1.text = opt[0]
        rb2.text = opt[1]
        rb3.text = opt[2]
        rb4.text = opt[3]

        submitbutton.setOnClickListener {
            if (radio_g.checkedRadioButtonId == -1) {
                Toast.makeText(applicationContext, "Please select one choice", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val uans = findViewById<View>(radio_g.checkedRadioButtonId) as RadioButton
            val ansText = uans.text.toString()

            if (ansText == answers[flag]) {
                correct++
                Toast.makeText(applicationContext, "Correct", Toast.LENGTH_SHORT).show()
            } else {
                wrong++
                Toast.makeText(applicationContext, "Wrong", Toast.LENGTH_SHORT).show()
            }

            flag++

            score.text = "$correct"

            if (flag < questions.size) {
                tv.text = questions[flag]
                rb1.text = opt[flag * 4]
                rb2.text = opt[flag * 4 + 1]
                rb3.text = opt[flag * 4 + 2]
                rb4.text = opt[flag * 4 + 3]
            } else {
                marks = correct
                val intentx = Intent(applicationContext, activity_results::class.java)
                startActivity(intentx)
            }

            radio_g.clearCheck()
        }

        quitbutton.setOnClickListener {
            val intentf = Intent(applicationContext, activity_results::class.java)
            startActivity(intentf)
        }
    }

    companion object {
        var marks = 0
        var correct = 0
        var wrong = 0
    }
}
