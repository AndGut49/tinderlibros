package com.libros.tinderlibros

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputLayout

val userC="developer"
var passwordC="developer"
class MainActivity : AppCompatActivity() {

    private lateinit var loginButton : Button
    private lateinit var signinButton : Button
    private lateinit var usernameInput : TextInputLayout
    private lateinit var passwordInput : TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton = findViewById(R.id.loginButton)
        signinButton = findViewById(R.id.signinButton)
        usernameInput = findViewById(R.id.userInput)
        passwordInput = findViewById(R.id.paswordInput)

        loginButton.setOnClickListener{
            if (validateUserData()){
                toMainActivity()
                finish()
            }
        }

        signinButton.setOnClickListener {
            toSignActivity()
        }
    }

    private fun validateUserData(): Boolean {
        val name = usernameInput.editText?.text.toString()
        val password = usernameInput.editText?.text.toString()

        if (name.isEmpty()) {
            usernameInput.error = "Ingrese un nombre"
        } else {
            usernameInput.error = null
            return true
        }

        if (password.isEmpty()) {
            passwordInput.error = "Ingrese una contraseña"
        } else if (password.length < 3) {
            passwordInput.error = "Constraseña muy corta"
        } else {
            passwordInput.error = null
            return true
        }

        return false
    }

    private fun toMainActivity() {
        val loginIntent = Intent(this,Principal::class.java)
        startActivity(loginIntent)
        finish()
    }

    private fun toSignActivity(){
        val siginIntent = Intent (this,SigninActivity::class.java)
        startActivity(siginIntent)
    }
}