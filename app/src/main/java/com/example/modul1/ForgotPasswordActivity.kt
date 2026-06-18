package com.example.modul1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class ForgotPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val ivBackForgot = findViewById<ImageView>(R.id.ivBackForgot)
        val etForgotInput = findViewById<EditText>(R.id.etForgotInput)
        val btnResetPassword = findViewById<Button>(R.id.btnResetPassword)

        val userPrefs = UserPreferences(this)

        ivBackForgot.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        btnResetPassword.setOnClickListener {
            val input = etForgotInput.text.toString().trim()

            when {
                input.isEmpty() -> Toast.makeText(this, "Email atau User ID wajib diisi", Toast.LENGTH_SHORT).show()
                !userPrefs.isUserExists(input) -> Toast.makeText(this, "Email atau User ID tidak terdaftar", Toast.LENGTH_SHORT).show()
                else -> showResetPasswordDialog(userPrefs, input)
            }
        }
    }

    private fun showResetPasswordDialog(userPrefs: UserPreferences, input: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Reset Password")

        val dialogView = layoutInflater.inflate(R.layout.dialog_reset_password, null)
        builder.setView(dialogView)

        val etNewPassword = dialogView.findViewById<EditText>(R.id.etNewPassword)
        val etConfirmPassword = dialogView.findViewById<EditText>(R.id.etConfirmPassword)

        builder.setPositiveButton("Reset") { _, _ ->
            val newPassword = etNewPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()

            when {
                newPassword.isEmpty() -> Toast.makeText(this, "Password baru harus diisi", Toast.LENGTH_SHORT).show()
                newPassword.length < 6 -> Toast.makeText(this, "Password minimal 6 karakter", Toast.LENGTH_SHORT).show()
                confirmPassword.isEmpty() -> Toast.makeText(this, "Konfirmasi password harus diisi", Toast.LENGTH_SHORT).show()
                newPassword != confirmPassword -> Toast.makeText(this, "Password tidak cocok", Toast.LENGTH_SHORT).show()
                else -> {
                    userPrefs.updatePassword(input, newPassword)
                    Toast.makeText(this, "Password berhasil direset, silakan login", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
            }
        }

        builder.setNegativeButton("Batal", null)
        builder.show()
    }
}