package com.example.modul1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class TransferActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfer)

        val btnTransfer = findViewById<Button>(R.id.btnTransfer)

        btnTransfer.setOnClickListener {

            Toast.makeText(
                this,
                "Transfer Berhasil",
                Toast.LENGTH_SHORT
            ).show()

        }
    }
}