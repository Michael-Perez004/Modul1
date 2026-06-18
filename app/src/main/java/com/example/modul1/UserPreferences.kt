package com.example.modul1

import android.content.Context
import java.security.MessageDigest

class UserPreferences(context: Context) {

    private val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun register(username: String, password: String, nama: String, email: String) {
        val users = getUsers().toMutableSet()
        users.add(username)
        prefs.edit()
            .putString(KEY_USERS, users.joinToString(","))
            .putString(key(PASSWORD, username), hashPassword(password))
            .putString(key(NAMA, username), nama)
            .putString(key(EMAIL, username), email)
            .commit()
    }

    fun login(usernameOrEmail: String, password: String): Boolean {
        val username = resolveUsername(usernameOrEmail) ?: return false
        val storedPass = prefs.getString(key(PASSWORD, username), null) ?: return false
        return storedPass == hashPassword(password)
    }

    fun getUserName(usernameOrEmail: String): String? {
        return resolveUsername(usernameOrEmail)
    }

    fun getNama(username: String): String? {
        return prefs.getString(key(NAMA, username), null)
    }

    fun getEmail(username: String): String? {
        return prefs.getString(key(EMAIL, username), null)
    }

    fun getUsers(): Set<String> {
        val raw = prefs.getString(KEY_USERS, "") ?: ""
        return if (raw.isEmpty()) emptySet() else raw.split(",").toSet()
    }

    fun isUserExists(usernameOrEmail: String): Boolean {
        return resolveUsername(usernameOrEmail) != null
    }

    fun updatePassword(usernameOrEmail: String, newPassword: String): Boolean {
        val username = resolveUsername(usernameOrEmail) ?: return false
        prefs.edit()
            .putString(key(PASSWORD, username), hashPassword(newPassword))
            .apply()
        return true
    }

    private fun resolveUsername(usernameOrEmail: String): String? {
        val users = getUsers()
        if (usernameOrEmail in users) return usernameOrEmail
        return users.firstOrNull { prefs.getString(key(EMAIL, it), "") == usernameOrEmail }
    }

    // Session management
    fun saveSession(username: String) {
        prefs.edit().putString(KEY_SESSION, username).apply()
    }

    fun getSession(): String? {
        return prefs.getString(KEY_SESSION, null)
    }

    fun clearSession() {
        prefs.edit().remove(KEY_SESSION).apply()
    }

    private fun hashPassword(password: String): String {
        val digest = MessageDigest.getInstance("SHA-256")
        val hash = digest.digest(password.toByteArray(Charsets.UTF_8))
        return hash.joinToString("") { "%02x".format(it) }
    }

    private fun key(field: String, username: String) = "${username}_$field"

    companion object {
        private const val PREFS_NAME = "bni_user_data"
        private const val KEY_USERS = "registered_users"
        private const val KEY_SESSION = "current_session"
        private const val PASSWORD = "password"
        private const val NAMA = "nama"
        private const val EMAIL = "email"
    }
}
