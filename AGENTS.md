# AGENTS.md

## Project

Single-module Android app (Kotlin + XML), college demo simulating BNI Mobile Banking UI. No networking, no database, no DI — all data hardcoded.

## Build & Run

```bash
./gradlew assembleDebug        # debug APK
./gradlew installDebug         # build + install on device/emulator
./gradlew test                 # unit tests (trivial, one test)
./gradlew lint                 # Android lint
./gradlew build                # assemble + test + lint
```

Gradle 9.2.1, AGP 8.7.3, Kotlin 2.0.21, Java 11 source/target, JDK 21 daemon.

## Architecture

- **Entrypoint**: `LoginActivity` is the real launcher (`MAIN`/`LAUNCHER`). `MainActivity` is a splash-redirect that immediately opens `LoginActivity` and finishes itself.
- **Navigation**: Explicit Intents only — no Jetpack Navigation Component, no Fragments, no ViewModel/MVVM.
- **ViewBinding**: enabled (`buildFeatures.viewBinding = true`) but **unused** — all activities use `findViewById<>()`. Keep consistent unless refactoring.
- **Dependencies** are hardcoded in `app/build.gradle.kts` (not using the version catalog `gradle/libs.versions.toml` except for plugins).

## Navigation Flow

```
MainActivity (splash) → LoginActivity (launcher)
  ├── RegisterActivity
  ├── ForgotPasswordActivity
  └── HomeActivity (after login)
       ├── TransferActivity, QrisActivity, EwalletActivity
       ├── PembayaranActivity, PembelianActivity, MutasiActivity
       └── DetailActivity (via RecyclerView click)
```

Bottom nav has 3 tabs (Home, Transaksi, Profile) — only Home is functional; others show Toasts.

## Code Layout

All source in `app/src/main/java/com/example/modul1/`. 12 activities + `TransaksiModel` (data class) + `TransaksiAdapter` (RecyclerView adapter). Layouts in `res/layout/`.

## Notable

- `minSdk = 24`, `targetSdk = compileSdk = 34`, `applicationId = com.example.modul1`, app label "BNI Mobile Banking".
- No CI, no pre-commit, no formatter config beyond `kotlin.code.style=official`.
- `AndroidManifest.xml` has a broad `<queries>` block for implicit intents (browser, maps, dial, share, camera, gallery) — Android 11+ package visibility.
- `ExampleInstrumentedTest.kt` is an empty file (0 lines).
