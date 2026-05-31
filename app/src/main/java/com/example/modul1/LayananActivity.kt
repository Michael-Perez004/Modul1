package com.example.modul1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class LayananActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layanan)

        // Lokasi ATM / Cabang BNI
        findViewById<CardView>(R.id.cardMap).setOnClickListener {
            val uri = Uri.parse("geo:0,0?q=Bank+BNI+terdekat")
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }

        // Ambil Foto
        findViewById<CardView>(R.id.cardCamera).setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "Kamera tidak tersedia", Toast.LENGTH_SHORT).show()
            }
        }

        // Bagikan Aplikasi
        findViewById<CardView>(R.id.cardShare).setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Download BNI Mobile Banking sekarang! https://www.bni.co.id")
            }
            startActivity(Intent.createChooser(intent, "Bagikan via"))
        }

        // Website BNI
        findViewById<CardView>(R.id.cardWebsite).setOnClickListener {
            val uri = Uri.parse("https://www.bni.co.id")
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }

        // Hubungi BNI
        findViewById<CardView>(R.id.cardCall).setOnClickListener {
            val uri = Uri.parse("tel:1500046")
            startActivity(Intent(Intent.ACTION_DIAL, uri))
        }

        // YouTube BNI
        findViewById<CardView>(R.id.cardYoutube).setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:UC_bnI"))
                startActivity(intent)
            } catch (_: Exception) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/@BNI")))
            }
        }

        // Instagram BNI
        findViewById<CardView>(R.id.cardInstagram).setOnClickListener {
            try {
                val intent = packageManager.getLaunchIntentForPackage("com.instagram.android")
                if (intent != null) {
                    startActivity(intent)
                } else {
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/bni")))
                }
            } catch (_: Exception) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/bni")))
            }
        }

        // Berita Terkini
        findViewById<CardView>(R.id.cardNews).setOnClickListener {
            val uri = Uri.parse("https://www.kompas.com")
            startActivity(Intent(Intent.ACTION_VIEW, uri))
        }
    }
}
