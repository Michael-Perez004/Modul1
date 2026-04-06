package com.example.modul1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var btnReset: Button
    private lateinit var ivBackForgot: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        btnReset = findViewById(R.id.btnResetPassword)
        ivBackForgot = findViewById(R.id.ivBackForgot)

        // 🔙 BACK → LOGIN (explicit intent)
        ivBackForgot.setOnClickListener {
            val intent = Intent(this@ForgotPasswordActivity, LoginActivity::class.java)

            // (opsional) kirim data ke login
            intent.putExtra("from", "forgot_password")

            startActivity(intent)
            finish()
        }

        // 🔁 RESET PASSWORD → LOGIN (explicit intent)
        btnReset.setOnClickListener {

            Toast.makeText(
                this,
                "Link reset password berhasil dikirim",
                Toast.LENGTH_SHORT
            ).show()

            val intent = Intent(this@ForgotPasswordActivity, LoginActivity::class.java)

            // kirim pesan ke login
            intent.putExtra("reset_status", "success")

            startActivity(intent)
            finish()
        }
    }
}