package com.example.modul1

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MutasiActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mutasi)

        val tvTotal = findViewById<TextView>(R.id.tvTotalMutasi)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerMutasi)

        val list = arrayListOf(
            TransaksiModel("Transfer BCA", "22 Mei 2026", "Rp 500.000"),
            TransaksiModel("Pembayaran PLN", "21 Mei 2026", "Rp 250.000"),
            TransaksiModel("QRIS Indomaret", "20 Mei 2026", "Rp 75.000"),
            TransaksiModel("Top Up DANA", "19 Mei 2026", "Rp 100.000"),
            TransaksiModel("Transfer Mandiri", "18 Mei 2026", "Rp 1.200.000")
        )

        tvTotal.text = "${list.size} Transaksi"

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TransaksiAdapter(list)
    }
}
