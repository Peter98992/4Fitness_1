package com.example.a4fitness_1

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.google.firebase.auth.FirebaseAuth

class activity_login : AppCompatActivity() {

    //  VARIABLES FOR LOGIN SYSTEM
    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText
    private lateinit var buttonLogin: AppCompatButton
    private lateinit var mAuth: FirebaseAuth
    private var emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        //  LOGIN SYSTEM

        inputPassword = findViewById(R.id.input_password)
        inputEmail = findViewById(R.id.input_email)
        mAuth = FirebaseAuth.getInstance()
        buttonLogin = findViewById(R.id.button_login)

        //IF ACCOUNT LOG IN DON'T REQUEST PASSWORD
        if (mAuth.currentUser != null) {
            sendUserToNextActivity()
        }
        else {
            //  Opens Register Activity
            val createNewAccount = findViewById<TextView>(R.id.createNewAccount)
            createNewAccount.setOnClickListener {
                startActivity(Intent(this, activity_register::class.java))
            }



            buttonLogin.setOnClickListener {
                performLogin()
            }
        }

        // Opens Reset Password Activity

        val forgotPassword = findViewById<TextView>(R.id.forgotPassword)
        forgotPassword.setOnClickListener {
            startActivity(Intent(this, activity_resetPassword::class.java))
        }

    }

    private fun performLogin() {
        mAuth = FirebaseAuth.getInstance()
        emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        inputPassword = findViewById(R.id.input_password)
        inputEmail = findViewById(R.id.input_email)


        val email = inputEmail.text.toString()
        val password = inputPassword.text.toString()


        if (!email.matches(emailPattern.toRegex())) {
            inputEmail.error = "Invalid Email"
        }
        else if (password.isEmpty() || password.length < 6) {
            inputPassword.error = "Password is too short"
        }
        else
        {

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    sendUserToNextActivity()
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                }
                else
                {
                    inputEmail.error = "Email or password doesn't match"
                    inputPassword.error = "Email or password doesn't match"
                }

            }
        }

    }
    private fun sendUserToNextActivity() {
        val intentToMainActivity = Intent(this, MainActivity::class.java)
        finish()
        startActivity(intentToMainActivity)
    }
        // Do nothing when back is pressed
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        // do nothing
    }
}