package com.example.a4fitness_1

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.google.firebase.auth.FirebaseAuth


class activity_register : AppCompatActivity() {

    // DECLARING VARIABLES FOR REGISTRATION SYSTEM
    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText
    private lateinit var inputPasswordConfirm: EditText
    private lateinit var mAuth: FirebaseAuth
    private var emailPattern = "[a-zA-Z\\d._-]+@[a-z]+\\.+[a-z]+"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_register)
        val buttonRegister: AppCompatButton = findViewById(R.id.button_register)


        // Already Have account
        val alreadyHaveAccount = findViewById<TextView>(R.id.alreadyHaveAccount)
        alreadyHaveAccount.setOnClickListener {
            startActivity(Intent(this, activity_login::class.java))
        }

        //Functions

        buttonRegister.setOnClickListener {
            performAuth()
        }


    }

    private fun performAuth() {
        mAuth = FirebaseAuth.getInstance()
        emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        inputPasswordConfirm = findViewById(R.id.input_passwordConfirm)
        inputPassword = findViewById(R.id.input_password)
        inputEmail = findViewById(R.id.input_name)


        val email = inputEmail.text.toString()
        val password = inputPassword.text.toString()
        val confirmPassword = inputPasswordConfirm.text.toString()




        if(!email.matches(emailPattern.toRegex()))
        {
            inputEmail.error = "Invalid Email"
        }
        else if(password.isEmpty() || password.length < 6)
        {
            inputPassword.error = "Password is too short"
        }
        else if(password != confirmPassword)
        {
            inputPasswordConfirm.error = "Password does not match in both fields"
        }
        else
        {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    sendUserToNextActivity()
                } else {
                    Toast.makeText(this, "" + task.exception, Toast.LENGTH_SHORT).show()
                }

            }


        }
    }


    private fun sendUserToNextActivity() {
        val intentToStartActivity = Intent(this, start_page::class.java)
        finish()
        startActivity(intentToStartActivity)
    }


}

