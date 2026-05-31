# 📱 Demo UI Mobile Banking BNI

Aplikasi Android demo UI Mobile Banking BNI — tugas kampus menggunakan Kotlin dan XML di Android Studio.

## 🎯 Enam Tugas

| Tugas | Fitur | Activity |
|---|---|---|
| **1.** Login & Register | Halaman login dan registrasi | `LoginActivity`, `RegisterActivity` |
| **2.** Explicit Intent | Navigasi antar halaman + Forgot Password | `ForgotPasswordActivity`, `HomeActivity` |
| **3.** Implicit Intent | Lokasi ATM (Maps), Kamera, Bagikan, Website BNI, Hubungi BNI, YouTube, Instagram, Berita | `LayananActivity` |
| **4.** Menu Android | Toolbar menu (Profile, Setting, Layanan, Logout) + Bottom Navigation (Home, Transaksi, Profile) | `menu_toolbar.xml`, `bottom_menu.xml` |
| **5.** RecyclerView | Riwayat transaksi dengan RecyclerView + adapter | `MutasiActivity`, `TransaksiAdapter` |
| **6.** Detail Item | Detail transaksi dari klik item RecyclerView | `DetailActivity` |

## 📱 Fitur Aplikasi

- **Login** — form username/password dengan validasi
- **Register** — registrasi akun baru
- **Forgot Password** — reset password via email/username
- **Home** — dashboard saldo + 6 menu layanan (Transfer, QRIS, E-Wallet, Pembayaran, Pembelian, Mutasi)
- **Transaksi** — riwayat transaksi dengan RecyclerView
- **Profile** — info pengguna (Michael Kemal)
- **Layanan (Implicit Intent)** — 8 fitur: Lokasi ATM, Ambil Foto, Bagikan, Website BNI, Hubungi BNI 1500046, YouTube, Instagram, Berita
- **Setting** — dialog pengaturan aplikasi

## 🛠️ Build & Run

```bash
./gradlew assembleDebug
./gradlew installDebug
./gradlew test
./gradlew lint
```

**Gradle 9.2.1** · **AGP 8.7.3** · **Kotlin 2.0.21** · **minSdk 24** · **targetSdk 34**

## 👨‍💻 Developer

**Michael Kemal** — Mobile Programming
