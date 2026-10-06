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
    id("com.syedm.elpl.android") version "1.0.10" // This plugin is not yet available, pending approval from Gradle.
}

android {
    namespace = "com.syedm.testproject"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.syedm.testproject"
        minSdk = 24
        targetSdk = 37
        versionCode = 18
        versionName = "4.1.1"
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


    testImplementation(libs.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)
}

