package com.example.modul1

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val etShareText = findViewById<EditText>(R.id.etShareText)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val etLocation = findViewById<EditText>(R.id.etLocation)
        val etWebsite = findViewById<EditText>(R.id.etWebsite)

        val btnShare = findViewById<Button>(R.id.btnShare)
        val btnCall = findViewById<Button>(R.id.btnCall)
        val btnMaps = findViewById<Button>(R.id.btnMaps)
        val btnWebsite = findViewById<Button>(R.id.btnWebsite)
        val btnCamera = findViewById<Button>(R.id.btnCamera)
        val btnGallery = findViewById<Button>(R.id.btnGallery)
        val btnAlarm = findViewById<Button>(R.id.btnAlarm)
        val btnContacts = findViewById<Button>(R.id.btnContacts)
        val btnNews = findViewById<Button>(R.id.btnNews)
        val btnInstagram = findViewById<Button>(R.id.btnInstagram)
        val btnFacebook = findViewById<Button>(R.id.btnFacebook)
        val btnYoutube = findViewById<Button>(R.id.btnYoutube)
        val btnWhatsapp = findViewById<Button>(R.id.btnWhatsapp)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        btnShare.setOnClickListener {
            val text = etShareText.text.toString().trim()

            if (text.isEmpty()) {
                Toast.makeText(this, "Masukkan teks terlebih dahulu", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_SUBJECT, "BNI Mobile Banking")
                intent.putExtra(Intent.EXTRA_TEXT, text)
                startActivity(Intent.createChooser(intent, "Share to"))
            }
        }

        btnCall.setOnClickListener {
            val phone = etPhone.text.toString().trim()

            if (phone.isEmpty()) {
                Toast.makeText(this, "Masukkan nomor telepon", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:$phone")
                startActivity(intent)
            }
        }

        btnMaps.setOnClickListener {
            val location = etLocation.text.toString().trim()

            if (location.isEmpty()) {
                Toast.makeText(this, "Masukkan lokasi", Toast.LENGTH_SHORT).show()
            } else {
                val uri = Uri.parse("geo:0,0?q=${Uri.encode(location)}")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                intent.setPackage("com.google.android.apps.maps")

                try {
                    startActivity(intent)
                } catch (e: ActivityNotFoundException) {
                    startActivity(Intent(Intent.ACTION_VIEW, uri))
                }
            }
        }

        btnWebsite.setOnClickListener {
            var website = etWebsite.text.toString().trim()

            if (website.isEmpty()) {
                Toast.makeText(this, "Masukkan alamat website", Toast.LENGTH_SHORT).show()
            } else {
                if (!website.startsWith("http://") && !website.startsWith("https://")) {
                    website = "https://$website"
                }

                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(website)))
            }
        }

        btnCamera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "Camera tidak tersedia", Toast.LENGTH_SHORT).show()
            }
        }

        btnGallery.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivity(intent)
        }

        btnAlarm.setOnClickListener {
            val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
                putExtra(AlarmClock.EXTRA_MESSAGE, "Alarm dari aplikasi BNI")
                putExtra(AlarmClock.EXTRA_HOUR, 7)
                putExtra(AlarmClock.EXTRA_MINUTES, 0)
            }

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, "Aplikasi alarm tidak tersedia", Toast.LENGTH_SHORT).show()
            }
        }

        btnContacts.setOnClickListener {
            try {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"))
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "Aplikasi kontak tidak tersedia", Toast.LENGTH_SHORT).show()
            }
        }

        btnNews.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://news.google.com/")))
        }

        btnInstagram.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/")))
        }

        btnFacebook.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/")))
        }

        btnYoutube.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/")))
        }

        btnWhatsapp.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/6281234567890")))
        }

        btnLogout.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}