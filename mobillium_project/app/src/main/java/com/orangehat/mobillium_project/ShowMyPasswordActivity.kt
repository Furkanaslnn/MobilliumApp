package com.orangehat.mobillium_project

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ShowMyPasswordActivity : AppCompatActivity() {

    lateinit var sifreleri_göster: TextView
    lateinit var searchEditText: EditText
    lateinit var db: DataBaseHelperPassword

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_my_password)

        sifreleri_göster = findViewById(R.id.sifreleri_göster)
        searchEditText = findViewById(R.id.searchShowPasswd)
        db = DataBaseHelperPassword(this)

        val data = db.readData()
        showPasswords(data)

        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Before text changed
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // On text changed
                val searchText = s.toString()
                val searchResults = db.searchInData(searchText)
                showPasswords(searchResults)
            }

            override fun afterTextChanged(s: Editable?) {
                // After text changed
            }
        })
    }

    private fun showPasswords(passwords: List<Passwords>) {
        sifreleri_göster.text = ""
        for (password in passwords) {
            sifreleri_göster.append("${password.id} ${password.passwordName} ${password.password}\n")
        }
    }

    fun geriDon(view: View) {
        val intent = Intent(this, MenuScreen::class.java)
        startActivity(intent)
        finishAffinity()
    }
}