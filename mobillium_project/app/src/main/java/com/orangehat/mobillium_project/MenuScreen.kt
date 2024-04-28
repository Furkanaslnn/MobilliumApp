package com.orangehat.mobillium_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlin.random.Random

class MenuScreen : AppCompatActivity() {

    lateinit var createPasswordButton: Button
    lateinit var showMyPasswordButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_screen2)

        createPasswordButton = findViewById(R.id.createPasswordButton)
        showMyPasswordButton = findViewById(R.id.showMyPasswordButton)

        createPasswordButton.setOnClickListener {
            intent = Intent(applicationContext, createPasswordScreen::class.java)
            startActivity(intent)
        }

        showMyPasswordButton.setOnClickListener {
            intent = Intent(applicationContext, ShowMyPasswordActivity::class.java)
            startActivity(intent)
        }

    }
}