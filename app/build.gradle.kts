import java.util.Properties
import java.io.File
import java.io.FileOutputStream
import java.util.zip.ZipOutputStream
import com.android.build.api.variant.ScopedArtifacts
import com.android.build.api.artifact.ScopedArtifact

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    id("com.google.gms.google-services") version "4.5.0"
    id("io.github.mujtabaishaq5.elpl") version "1.0.13" // This plugin is not yet available, pending approval from Gradle.
}

android {
    namespace = "com.syedm.testproject"
    compileSdk = 37

    defaultConfig {
        // Read GEMINI_API_KEY from local.properties
        val localProperties = Properties()
        val localPropertiesFile = rootProject.file("local.properties")
        if (localPropertiesFile.exists()) {
            localProperties.load(localPropertiesFile.inputStream())
        }
        val geminiApiKey = localProperties.getProperty("GEMINI_API_KEY", "")

        // Inject it into Android's generated BuildConfig class
        buildConfigField("String", "GEMINI_API_KEY", "\"$geminiApiKey\"")

        applicationId = "com.syedm.testproject"
        minSdk = 24
        targetSdk = 37
        versionCode = 19
        versionName = "4.3.3"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }



    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
}


dependencies {


    // 3. Standard dependencies
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation("io.github.muddz:styleabletoast:2.4.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("io.github.oothp:android-pdf-viewer:3.2.0-beta06")
    implementation(platform("com.google.firebase:firebase-bom:34.19.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-database:20.3.0")
    implementation("com.android.billingclient:billing:8.0.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.material:material:1.12.0")
    implementation("com.google.android.play:app-update:2.1.0")
    implementation("com.google.firebase:firebase-messaging")
    // Google Generative AI SDK for Android
    implementation("com.google.ai.client.generativeai:generativeai:0.3.0")
// Guava for ListenableFuture and FutureCallbacks
    implementation("com.google.guava:guava:31.1-android")


    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)
}

