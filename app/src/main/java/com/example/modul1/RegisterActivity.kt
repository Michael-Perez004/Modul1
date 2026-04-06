package com.example.modul1

import android.content.Intent // ⬅️ TAMBAHAN
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val ivBack = findViewById<ImageView>(R.id.ivBack)
        val etFullName = findViewById<EditText>(R.id.etFullName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val etUserId = findViewById<EditText>(R.id.etRegisterUserId)
        val etPassword = findViewById<EditText>(R.id.etRegisterPassword)
        val btnCreateAccount = findViewById<Button>(R.id.btnCreateAccount)

        // 🔙 BACK → LOGIN (Explicit Intent)
        ivBack.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnCreateAccount.setOnClickListener {
            if (
                etFullName.text.toString().trim().isEmpty() ||
                etEmail.text.toString().trim().isEmpty() ||
                etPhone.text.toString().trim().isEmpty() ||
                etUserId.text.toString().trim().isEmpty() ||
                etPassword.text.toString().trim().isEmpty()
            ) {
                Toast.makeText(this, "Semua field wajib diisi", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Registrasi demo berhasil", Toast.LENGTH_SHORT).show()

                // ✅ REGISTER → LOGIN (Explicit Intent)
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}