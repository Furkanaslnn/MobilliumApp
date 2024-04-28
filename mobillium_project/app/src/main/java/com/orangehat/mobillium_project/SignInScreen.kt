package com.orangehat.mobillium_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.prefs.BackingStoreException

class SignInScreen : AppCompatActivity() {

    lateinit var signInUsername: EditText
    lateinit var signInPassword: EditText
    lateinit var signInButton: Button
    lateinit var goBackButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in_screen)

        signInUsername = findViewById(R.id.signInUsername)
        signInPassword = findViewById(R.id.signInPassword)
        signInButton = findViewById(R.id.signInButton)
        goBackButton = findViewById(R.id.goBackButton)

        val context = this
        val db = DataBaseHelper(context)

        signInButton.setOnClickListener {
            val myUsername = signInUsername.text.toString()
            val myPassword = signInPassword.text.toString()
            if (myUsername.isNotEmpty() && myPassword.isNotEmpty()){
                val user = User(myUsername, myPassword)
                db.insertData(user)
            }
            else{
                Toast.makeText(applicationContext, "Cannot Be Empty!", Toast.LENGTH_SHORT).show()
            }
        }

        goBackButton.setOnClickListener {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }
    }
}
