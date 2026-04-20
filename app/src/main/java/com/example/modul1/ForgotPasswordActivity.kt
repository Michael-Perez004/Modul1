package com.example.modul1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ForgotPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val ivBackForgot = findViewById<ImageView>(R.id.ivBackForgot)
        val etForgotInput = findViewById<EditText>(R.id.etForgotInput)
        val btnResetPassword = findViewById<Button>(R.id.btnResetPassword)

        ivBackForgot.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        btnResetPassword.setOnClickListener {
            val input = etForgotInput.text.toString().trim()

            if (input.isEmpty()) {
                Toast.makeText(this, "Email atau User ID wajib diisi", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Link reset password berhasil dikirim", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
    }
}