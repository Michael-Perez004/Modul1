plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.modul1"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.modul1"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner =
            "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility =
            JavaVersion.VERSION_11

        targetCompatibility =
            JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
    }

}

dependencies {

// Material Design
    implementation(
        "com.google.android.material:material:1.11.0"
    )

// AppCompat
    implementation(
        "androidx.appcompat:appcompat:1.6.1"
    )

// Constraint Layout
    implementation(
        "androidx.constraintlayout:constraintlayout:2.1.4"
    )

// Activity KTX
    implementation(
        "androidx.activity:activity-ktx:1.8.2"
    )

// RecyclerView
    implementation(
        "androidx.recyclerview:recyclerview:1.3.2"
    )

// CardView
    implementation(
        "androidx.cardview:cardview:1.0.0"
    )

// Core KTX
    implementation(
        "androidx.core:core-ktx:1.12.0"
    )

// Lifecycle
    implementation(
        "androidx.lifecycle:lifecycle-runtime-ktx:2.7.0"
    )
    // Firebase
    implementation(platform("com.google.firebase:firebase-bom:33.1.2"))
    implementation("com.google.firebase:firebase-auth")

// Unit Test
    testImplementation(
        "junit:junit:4.13.2"
    )

// Android Test
    androidTestImplementation(
        "androidx.test.ext:junit:1.1.5"
    )

    androidTestImplementation(
        "androidx.test.espresso:espresso-core:3.5.1"
    )

}
