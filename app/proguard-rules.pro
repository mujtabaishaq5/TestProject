# =========================================================
# 1. ELPL & APP CORE (CRITICAL)
# Keep all custom ELPL bytecode and activities intact
# =========================================================
-keep class com.syedm.testproject.** { *; }
-keepclassmembers class com.syedm.testproject.** { *; }

# =========================================================
# 2. GOOGLE PLAY BILLING
# =========================================================
-keep class com.android.billingclient.api.** { *; }
-dontwarn com.android.billingclient.**

# =========================================================
# 3. FIREBASE (Database, Messaging, Analytics)
# Firebase Realtime DB uses reflection to parse data models.
# Obfuscating it will cause database reads to return null.
# =========================================================
-keep class com.google.firebase.** { *; }
-keepclassmembers class com.google.firebase.** { *; }
-dontwarn com.google.firebase.**

# =========================================================
# 4. ANDROID PDF VIEWER
# PDF libraries rely on Native JNI code. If class names change,
# the C++ code cannot communicate with Android.
# =========================================================
-keep class io.github.oothp.** { *; }
-keep class com.github.barteksc.pdfviewer.** { *; }
-dontwarn io.github.oothp.**
-dontwarn com.github.barteksc.pdfviewer.**

# =========================================================
# 5. STYLEABLE TOAST
# =========================================================
-keep class io.github.muddz.styleabletoast.** { *; }
-dontwarn io.github.muddz.styleabletoast.**

# =========================================================
# 6. ANDROIDX & MATERIAL VIEWS
# Prevents crashes when standard or custom views are inflated
# directly from your XML layout files.
# =========================================================
-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

# =========================================================
# PLAY CORE (IN-APP UPDATES)
# =========================================================
-keep class com.google.android.play.core.appupdate.** { *; }
-keep class com.google.android.play.core.install.model.** { *; }
-dontwarn com.google.android.play.core.**# =========================================================
                                         # PLAY CORE (IN-APP UPDATES)
                                         # =========================================================
                                         -keep class com.google.android.play.core.appupdate.** { *; }
                                         -keep class com.google.android.play.core.install.model.** { *; }
                                         -dontwarn com.google.android.play.core.**