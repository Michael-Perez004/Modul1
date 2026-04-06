package com.example.modul1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnLogout = findViewById(R.id.btnLogout)

        btnLogout.setOnClickListener {

            // Tampilkan pesan logout
            Toast.makeText(this, "Anda berhasil logout", Toast.LENGTH_SHORT).show()

            // Explicit Intent ke LoginActivity
            val intent = Intent(this@HomeActivity, LoginActivity::class.java)

            // Optional: bersihkan stack biar tidak bisa kembali ke Home
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(intent)
            finish()
        }
    }
}