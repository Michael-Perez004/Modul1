package com.example.modul1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etUserId = findViewById<EditText>(R.id.etUserId)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvRegister = findViewById<TextView>(R.id.tvRegister)

        // 👉 TAMBAHAN (kalau ada di XML kamu)
        val tvForgot = findViewById<TextView>(R.id.tvLupaPassword)

        btnLogin.setOnClickListener {
            val userId = etUserId.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (userId.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "User ID dan Password wajib diisi", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login demo berhasil", Toast.LENGTH_SHORT).show()

                // ✅ EXPLICIT INTENT → KE HOME
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }

        // ✅ EXPLICIT INTENT → KE REGISTER
        tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // ✅ EXPLICIT INTENT → KE FORGOT PASSWORD
        tvForgot.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
    }
}