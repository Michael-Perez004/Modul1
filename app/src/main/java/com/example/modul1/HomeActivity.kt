package com.example.modul1

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // ==========================
        // MENU BNI
        // ==========================

        findViewById<CardView>(R.id.cardTransfer)
            .setOnClickListener {

                startActivity(
                    Intent(
                        this,
                        TransferActivity::class.java
                    )
                )

            }

        findViewById<CardView>(R.id.cardQris)
            .setOnClickListener {

                startActivity(
                    Intent(
                        this,
                        QrisActivity::class.java
                    )
                )

            }

        findViewById<CardView>(R.id.cardEwallet)
            .setOnClickListener {

                startActivity(
                    Intent(
                        this,
                        EwalletActivity::class.java
                    )
                )

            }

        findViewById<CardView>(R.id.cardPembayaran)
            .setOnClickListener {

                startActivity(
                    Intent(
                        this,
                        PembayaranActivity::class.java
                    )
                )

            }

        findViewById<CardView>(R.id.cardPembelian)
            .setOnClickListener {

                startActivity(
                    Intent(
                        this,
                        PembelianActivity::class.java
                    )
                )

            }

        findViewById<CardView>(R.id.cardMutasi)
            .setOnClickListener {

                startActivity(
                    Intent(
                        this,
                        MutasiActivity::class.java
                    )
                )

            }

        // ==========================
        // BOTTOM NAVIGATION
        // ==========================

        val bottomNav =
            findViewById<BottomNavigationView>(
                R.id.bottomNavigation
            )

        bottomNav.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.nav_home -> {

                    Toast.makeText(
                        this,
                        "Home",
                        Toast.LENGTH_SHORT
                    ).show()

                    true
                }

                R.id.nav_transaksi -> {

                    startActivity(
                        Intent(
                            this,
                            MutasiActivity::class.java
                        )
                    )

                    true
                }

                R.id.nav_profile -> {

                    startActivity(
                        Intent(
                            this,
                            ProfileActivity::class.java
                        )
                    )

                    true
                }

                else -> false
            }

        }

    }

    // ==========================
    // OPTION MENU
    // ==========================

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(
            R.menu.menu_toolbar,
            menu
        )

        return true
    }

    override fun onOptionsItemSelected(
        item: MenuItem
    ): Boolean {

        return when (item.itemId) {

            R.id.menu_profile -> {

                startActivity(
                    Intent(
                        this,
                        ProfileActivity::class.java
                    )
                )

                true
            }

            R.id.menu_setting -> {

                val options = arrayOf(
                    "Ubah Bahasa",
                    "Notifikasi",
                    "Keamanan",
                    "Tentang Aplikasi"
                )

                android.app.AlertDialog.Builder(this)
                    .setTitle("Pengaturan")
                    .setItems(options) { _, which ->
                        Toast.makeText(
                            this,
                            options[which],
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    .show()

                true
            }

            R.id.menu_layanan -> {

                startActivity(
                    Intent(
                        this,
                        LayananActivity::class.java
                    )
                )

                true
            }

            R.id.menu_logout -> {

                FirebaseAuth.getInstance().signOut()

                startActivity(
                    Intent(
                        this,
                        LoginActivity::class.java
                    )
                )

                finish()

                true
            }

            else ->
                super.onOptionsItemSelected(item)
        }

    }

}