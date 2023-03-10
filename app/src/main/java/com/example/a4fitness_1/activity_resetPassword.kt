package com.example.a4fitness_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.google.firebase.auth.FirebaseAuth

@Suppress("NAME_SHADOWING")
class activity_resetPassword : AppCompatActivity() {

    private lateinit var inputEmail: EditText
    private lateinit var resetPasswordButton: AppCompatButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)


        // RESET THE PASSWORD
        resetPasswordButton = findViewById(R.id.button_resetPassword)
        inputEmail = findViewById(R.id.input_name)


        resetPasswordButton.setOnClickListener {
            FirebaseAuth.getInstance().fetchSignInMethodsForEmail(inputEmail.text.toString())
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val signInMethods = task.result!!.signInMethods
                        if (signInMethods != null) {
                            if (signInMethods.isNotEmpty()) {
                                FirebaseAuth.getInstance()
                                    .sendPasswordResetEmail(inputEmail.text.toString())
                                    .addOnCompleteListener { task ->
                                        if (task.isSuccessful) {
                                            Toast.makeText(this, "Email sent", Toast.LENGTH_SHORT).show()
                                        }
                                    }
                            } else {
                                inputEmail.error = "Email doesn't exist"
                            }
                        }
                    }
                }
        }



    }
}