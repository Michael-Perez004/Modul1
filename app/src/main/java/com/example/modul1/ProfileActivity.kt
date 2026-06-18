package com.example.modul1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val txtName = findViewById<TextView>(R.id.txtName)
        val txtEmail = findViewById<TextView>(R.id.txtEmail)
        val txtPhone = findViewById<TextView>(R.id.txtPhone)
        val txtUsername = findViewById<TextView>(R.id.txtUsername)

        val userPrefs = UserPreferences(this)
        val session = userPrefs.getSession()

        if (session != null) {
            txtName.text = userPrefs.getNama(session) ?: "-"
            txtUsername.text = session
            txtEmail.text = userPrefs.getEmail(session) ?: "-"
        }
    }
}
