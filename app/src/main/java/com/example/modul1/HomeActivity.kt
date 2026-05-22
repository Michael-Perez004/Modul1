package com.example.modul1

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.net.toUri
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var list: ArrayList<TransaksiModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // =========================
        // TOOLBAR
        // =========================

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // =========================
        // RECYCLERVIEW
        // =========================

        recyclerView = findViewById(R.id.recyclerView)

        list = arrayListOf(

            TransaksiModel(
                "Transfer BCA",
                "22 Mei 2026",
                "Rp 500.000"
            ),

            TransaksiModel(
                "Pembayaran PLN",
                "21 Mei 2026",
                "Rp 250.000"
            ),

            TransaksiModel(
                "QRIS Indomaret",
                "20 Mei 2026",
                "Rp 75.000"
            ),

            TransaksiModel(
                "Top Up Dana",
                "19 Mei 2026",
                "Rp 100.000"
            ),

            TransaksiModel(
                "Transfer Mandiri",
                "18 Mei 2026",
                "Rp 1.200.000"
            )

        )

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TransaksiAdapter(list)

        // =========================
        // QUICK MENU
        // =========================

        // MAPS

        findViewById<LinearLayout>(R.id.cardMaps)
            .setOnClickListener {

                val uri = "geo:0,0?q=Bank BNI Jayapura".toUri()

                val intent = Intent(Intent.ACTION_VIEW, uri)

                intent.setPackage("com.google.android.apps.maps")

                try {

                    startActivity(intent)

                } catch (_: ActivityNotFoundException) {

                    startActivity(
                        Intent(
                            Intent.ACTION_VIEW,
                            uri
                        )
                    )

                }

            }

        // CAMERA

        findViewById<LinearLayout>(R.id.cardCamera)
            .setOnClickListener {

                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

                if (intent.resolveActivity(packageManager) != null) {

                    startActivity(intent)

                } else {

                    Toast.makeText(
                        this,
                        "Camera tidak tersedia",
                        Toast.LENGTH_SHORT
                    ).show()

                }

            }

        // WEBSITE

        findViewById<LinearLayout>(R.id.cardWebsite)
            .setOnClickListener {

                startActivity(

                    Intent(
                        Intent.ACTION_VIEW,
                        "https://www.bni.co.id".toUri()
                    )

                )

            }

        // WHATSAPP

        findViewById<LinearLayout>(R.id.cardWhatsapp)
            .setOnClickListener {

                startActivity(

                    Intent(
                        Intent.ACTION_VIEW,
                        "https://wa.me/628123456789".toUri()
                    )

                )

            }

        // =========================
        // BOTTOM NAVIGATION
        // =========================

        val bottomNav =
            findViewById<BottomNavigationView>(R.id.bottomNavigation)

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

                    recyclerView.smoothScrollToPosition(0)

                    Toast.makeText(
                        this,
                        "Riwayat Transaksi",
                        Toast.LENGTH_SHORT
                    ).show()

                    true

                }

                R.id.nav_profile -> {

                    Toast.makeText(
                        this,
                        "Profile User",
                        Toast.LENGTH_SHORT
                    ).show()

                    true

                }

                else -> false

            }

        }

    }

    // =========================
    // OPTION MENU
    // =========================

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_toolbar, menu)

        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {

            R.id.menu_profile -> {

                Toast.makeText(
                    this,
                    "Menu Profile",
                    Toast.LENGTH_SHORT
                ).show()

                true

            }

            R.id.menu_setting -> {

                Toast.makeText(
                    this,
                    "Menu Setting",
                    Toast.LENGTH_SHORT
                ).show()

                true

            }

            R.id.menu_logout -> {

                startActivity(
                    Intent(
                        this,
                        LoginActivity::class.java
                    )
                )

                finish()

                true

            }

            else -> super.onOptionsItemSelected(item)

        }

    }

}