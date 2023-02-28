package com.example.a4fitness_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import com.google.firebase.auth.FirebaseAuth

class activity_settings : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    private lateinit var signOutButton: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // SIGN OUT
        mAuth = FirebaseAuth.getInstance()
        signOutButton = findViewById(R.id.button_logout)

        signOutButton.setOnClickListener{
            mAuth.signOut()
            sendUserToLoginScreen()
        }



    }

    private fun sendUserToLoginScreen() {
        val intentToLoginActivity = Intent(this, activity_login::class.java)
        finish()
        startActivity(intentToLoginActivity)
    }
}