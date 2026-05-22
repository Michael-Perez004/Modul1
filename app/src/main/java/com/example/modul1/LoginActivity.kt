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

        val etUser = findViewById<EditText>(R.id.etUser)
        val etPassword = findViewById<EditText>(R.id.etPassword)

        val btnLogin = findViewById<Button>(R.id.btnLogin)

        val tvRegister = findViewById<TextView>(R.id.tvRegister)

        val tvForgotPassword =
            findViewById<TextView>(R.id.tvForgotPassword)

        // LOGIN

        btnLogin.setOnClickListener {

            val username = etUser.text.toString().trim()

            val password = etPassword.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {

                Toast.makeText(
                    this,
                    "Username dan Password harus diisi",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                Toast.makeText(
                    this,
                    "Login berhasil",
                    Toast.LENGTH_SHORT
                ).show()

                startActivity(
                    Intent(
                        this,
                        HomeActivity::class.java
                    )
                )

            }

        }

        // REGISTER

        tvRegister.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    RegisterActivity::class.java
                )
            )

        }

        // FORGOT PASSWORD

        tvForgotPassword.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    ForgotPasswordActivity::class.java
                )
            )

        }

    }

}