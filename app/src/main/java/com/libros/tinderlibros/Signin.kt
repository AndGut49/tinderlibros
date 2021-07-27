package com.libros.tinderlibros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Signin : AppCompatActivity() {

    private lateinit var loginButton : Button
    private lateinit var signinButton : Button
    private lateinit var usernameInput : EditText
    private lateinit var passwordInput : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        loginButton = findViewById(R.id.loginButton)
        signinButton = findViewById(R.id.signinButton)

        loginButton.setOnClickListener{
            toMainActivity()
        }

        signinButton.setOnClickListener {
            toMainActivity()
        }
    }

    private fun toMainActivity() {
        val loginIntent = Intent(this,Principal::class.java)
        startActivity(loginIntent)
        finish()
    }
}