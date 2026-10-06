# 📱 ELPL Production App

> **Built entirely in ELPL.** 
> This production Android application is engineered **100%** using the [ELPL Programming Language](https://github.com/mujtabaishaq5/elpl). While build scripts and configuration files utilize standard Android tooling, zero Kotlin or Java was used for the application's core logic, UI, or backend integrations. 

This is a modern, high-performance Android application featuring real-time backend synchronization, secure payment processing, and a complex Material Design 3 user interface.

## ✨ Core Features

* **💬 Real-Time Messaging Engine:** Integrated with Firebase Realtime Database to handle instantaneous message transmission and dynamic UI updates.
* **🔔 Firebase Cloud Messaging (FCM):** Robust push notification architecture utilizing FCM to deliver real-time alerts securely to the client.
* **💳 Google Play Billing Integration:** Secure, production-ready implementation managing non-consumable user donations and automated purchase acknowledgment (`AcknowledgePurchaseParams`).
* **🔄 Seamless In-App Updates:** Integrated with the Google Play Core API to enforce and manage over-the-air (OTA) updates.
* **🎨 Complex Material Design 3 UI:** A deeply customized, responsive user interface built using modern Material 3 guidelines.
* **🚀 Native Splash Screen API:** Implements the Android 12+ Splash Screen API for a polished cold-start experience.

## 🏗️ Architecture & Tech Stack

* **Language:** ELPL (Custom language featuring JVM/LLVM backends)
* **Build System:** Gradle (via custom `com.syedm.elpl.android` compiler plugin)
* **Backend:** Firebase (Realtime Database, FCM)
* **Monetization:** Google Play Billing Client
* **UI Framework:** Android Views / Material 3

## ⚙️ Build Instructions

Because this project is built exclusively with ELPL, it requires the ELPL custom Gradle plugin to compile.

1. **Clone the repository**
2. **Build the project:** Run a standard Gradle build. On the very first run, the ELPL build toolchain will securely download the 105MB ELPL Compiler binary and cache it globally at `~/.elpl/cache/elpl-compiler.jar`.
   `./gradlew clean assembleDebug`

*(Note: Production backend credentials such as `google-services.json` and release keystores have been intentionally excluded from this repository for security purposes.)*

[![Get it on Google Play](https://play.google.com/intl/en_us/badges/static/images/badges/en_badge_web_generic.png)](https://play.google.com/store/apps/details?id=com.syedm.testproject)