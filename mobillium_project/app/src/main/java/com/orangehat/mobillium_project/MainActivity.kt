package com.orangehat.mobillium_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var loginButton: Button
    lateinit var goSignInButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        loginButton = findViewById(R.id.loginButton)
        goSignInButton = findViewById(R.id.goSignInButton)

        goSignInButton.setOnClickListener {
            intent = Intent(applicationContext, SignInScreen::class.java)
            startActivity(intent)
        }

        loginButton.setOnClickListener {
            val enteredUsername = username.text.toString()
            val enteredPassword = password.text.toString()

            val db = DataBaseHelper(this)
            val userList = db.readData()

            var isLoginSuccessful = false

            for (user in userList) {
                if (user.username == enteredUsername && user.password == enteredPassword) {
                    isLoginSuccessful = true
                    break
                }
            }

            if (isLoginSuccessful) {
                // Giriş başarılı
                Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
                val intent = Intent(applicationContext, MenuScreen::class.java)
                startActivity(intent)
            } else {
                // Giriş başarısız
                Toast.makeText(this, "Password or username is incorrect!", Toast.LENGTH_SHORT).show()
            }
        }


    }





}