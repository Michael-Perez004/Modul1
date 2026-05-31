package com.example.modul1

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class EwalletActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ewallet)

        val list = findViewById<ListView>(R.id.listWallet)

        val data = arrayOf(
            "DANA",
            "OVO",
            "GoPay",
            "ShopeePay"
        )

        list.adapter =
            ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                data)

    }
}