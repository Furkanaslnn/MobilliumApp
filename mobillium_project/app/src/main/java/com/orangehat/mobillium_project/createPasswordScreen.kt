package com.orangehat.mobillium_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class createPasswordScreen : AppCompatActivity() {

    lateinit var save: Button
    lateinit var  change: Button
    lateinit var  passwordName: EditText
    lateinit var createdPassword: EditText
    lateinit var goBack: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_password_screen)

        save = findViewById(R.id.save)
        change = findViewById(R.id.change)
        passwordName = findViewById(R.id.passwordName)
        createdPassword = findViewById(R.id.createdPassword)
        goBack = findViewById(R.id.goBack)

        val context = this
        var db = DataBaseHelperPassword(context)

        save.setOnClickListener {

            var etpasswordName = passwordName.text.toString()
            var etpassword = createdPassword.text.toString()

            if (etpasswordName.isNotEmpty() && etpassword.isNotEmpty()){
                //burada yapılacak
                var password = Passwords(etpasswordName,etpassword)
                db.insertData(password)
                //Toast.makeText(this, "Password Saved!", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(this, "Cannot Be Empty!", Toast.LENGTH_SHORT).show()
            }
        }

        fun change(): String {
            val tum_karakterler: List<Char> =
                ('a'..'z').toList() + ('A'..'Z').toList() + ('0'..'9').toList()
            val length = 12
            val password = (1..length)
                .map { tum_karakterler[Random.nextInt(0, tum_karakterler.size)] }
                .joinToString("")
            return password
        }

        change.setOnClickListener {
            val newPassword = change()
            createdPassword.setText(newPassword)
        }
        goBack.setOnClickListener {
            intent = Intent(applicationContext, MenuScreen::class.java)
            startActivity(intent)
        }


    }
}