package com.example.modul1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val nama = findViewById<TextView>(R.id.txtNama)
        val tanggal = findViewById<TextView>(R.id.txtTanggal)
        val nominal = findViewById<TextView>(R.id.txtNominal)
        val referensi = findViewById<TextView>(R.id.txtReferensi)

        nama.text = intent.getStringExtra("nama")
        tanggal.text = intent.getStringExtra("tanggal")
        nominal.text = intent.getStringExtra("nominal")

        referensi.text =
            "BNI" + System.currentTimeMillis().toString().takeLast(8)

    }
}