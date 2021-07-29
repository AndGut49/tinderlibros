package com.libros.tinderlibros

import android.content.Intent

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

val user="developer"
var password="developer"
class MainActivity : AppCompatActivity() {

    private lateinit var loginButton : Button
    private lateinit var signinButton : Button
    private lateinit var usernameInput : EditText
    private lateinit var passwordInput : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginButton = findViewById(R.id.loginButton)
        signinButton = findViewById(R.id.signinButton)
        usernameInput = findViewById(R.id.userInput)
        passwordInput = findViewById(R.id.paswordInput)

        loginButton.setOnClickListener{
            if( usernameInput.text.toString() == user && passwordInput.text.toString() == password){
                toMainActivity()
            }
            else{
                showDialog("Credenciales invalidas","Usuario o contraseña incorrecto. Por favor, verifica tus datos")
            }
        }

        signinButton.setOnClickListener {
            toSignActivity()
        }
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

    private fun showDialog(title:String, message:String){
        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton("OK"){dialogInterface,which ->}
            .create()
            .show()
    }
}