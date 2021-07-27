package com.libros.tinderlibros

import android.content.Intent

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var loginButton : Button
    private lateinit var signinButton : Button
    private lateinit var usernameInput : EditText
    private lateinit var passwordInput : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signinButton =findViewById(R.id.signinButton)
        signinButton.setOnClickListener{
            var siginIntent = Intent(this,Signin::class.java)
            startActivity(siginIntent)
        }

    }
}