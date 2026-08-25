# Bubblezilla — Application Brain & Technical Blueprint

This document serves as the **"Brain"** of the Bubblezilla application. It describes the complete structure, architecture, dependencies, build configurations, and external integrations (such as AdMob) of the project.

---

## 📱 Project Metadata

*   **Application Name**: Bubblezilla
*   **Package Namespace**: `com.startupzilla.bubblezilla`
*   **Platform**: Android
*   **Language**: Kotlin (`2.0.21` with Kotlin Compose Compiler)
*   **UI Framework**: Jetpack Compose (using Material 3)
*   **Min SDK**: `24` (Android 7.0)
*   **Target SDK**: `35` (Android 15)
*   **Compile SDK**: `36` (Android 16)
*   **Current Version**: `1.0.7` (Version Code `7`)

---

## 📂 Project Structure & Directory Layout

Below is the directory tree of the key source and configuration files in the project:

```
Bubblezilla/
│
├── gradle/
│   └── libs.versions.toml             # Gradle Version Catalog (dependencies/plugins versioning)
│
├── app/
│   ├── bubblee_zilla.jks              # Keystore file for release signing
│   ├── build.gradle.kts               # Module-level Gradle configuration (build types, dependencies)
│   ├── proguard-rules.pro             # Proguard rules for shrinking & obfuscation
│   │
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml    # App manifest (permissions, meta-data, Activity declarations)
│           │
│           ├── java/com/startupzilla/bubblezilla/
│           │   ├── MainActivity.kt    # Entry Activity; initializes AdMob & displays Compose content
│           │   ├── BannerAd.kt        # Composable wrapping Android AdView for banner ads
│           │   └── ui/theme/          # Design system (Color, Theme, Typography definitions)
│           │       ├── Color.kt
│           │       ├── Theme.kt
│           │       └── Type.kt
│           │
│           └── res/
│               ├── values/
│               │   ├── colors.xml     # XML Color resources
│               │   ├── strings.xml    # String resources (App name & AdMob Unit IDs)
│               │   └── themes.xml     # Base Android themes
│               └── xml/               # Network security & backup rules
│
├── build.gradle.kts                   # Project-level Gradle build script
├── settings.gradle.kts                # Project structure & repository configuration
├── local.properties                   # Local SDK paths
└── gradlew / gradlew.bat              # Gradle wrapper scripts
```

---

## 🛠️ Tech Stack & Key Dependencies

The project relies on a modern Android Jetpack Compose stack defined in [libs.versions.toml](file:///c:/Users/Aditya/OneDrive/Desktop/My%20Apps%20Development/Bubblezilla/gradle/libs.versions.toml):

*   **Jetpack Compose BOM**: `2024.09.00`
*   **Material 3**: Modern, material-design-compliant UI components
*   **Google Mobile Ads SDK**: `com.google.android.gms:play-services-ads:24.3.0`
*   **Lifecycle Runtime KTX**: `2.10.0`
*   **Activity Compose**: `1.13.0`

---

## 📢 AdMob Ads Integration

Bubblezilla comes with pre-configured AdMob setups for two types of ads: **Banner Ads** and **Interstitial Ads**.

### 1. AdMob Credentials & Identifiers
The AdMob configuration is split between [AndroidManifest.xml](file:///c:/Users/Aditya/OneDrive/Desktop/My%20Apps%20Development/Bubblezilla/app/src/main/AndroidManifest.xml) and [strings.xml](file:///c:/Users/Aditya/OneDrive/Desktop/My%20Apps%20Development/Bubblezilla/app/src/main/res/values/strings.xml):

*   **AdMob Application ID** *(declared in manifest)*: `ca-app-pub-5901475569503459~5686983705`
*   **Banner Ad Unit ID**: `ca-app-pub-5901475569503459/7744523959`
*   **Interstitial Ad Unit ID**: `ca-app-pub-5901475569503459/6775996569`

### 2. Banner Ad Composable ([BannerAd.kt](file:///c:/Users/Aditya/OneDrive/Desktop/My%20Apps%20Development/Bubblezilla/app/src/main/java/com/startupzilla/bubblezilla/BannerAd.kt))
A Compose-compatible banner wrapper that converts Android's classic `AdView` to a Composable element using `AndroidView`:
*   **Ad Size**: `AdSize.BANNER` (Standard 320x50dp banner).
*   **Lifecycle Management**: Uses `DisposableEffect` to trigger `adView.destroy()` when the Composable exits the composition to prevent memory leaks.

### 3. Interstitial Ads Core Logic ([MainActivity.kt](file:///c:/Users/Aditya/OneDrive/Desktop/My%20Apps%20Development/Bubblezilla/app/src/main/java/com/startupzilla/bubblezilla/MainActivity.kt))
*   **Initialization**: Initialized in `onCreate` via `MobileAds.initialize(this)`.
*   **Preloading**: `loadInterstitialAd()` loads the ad unit and stores the reference in `interstitialAd`.
*   **Auto-Preload**: Upon dismissal (`onAdDismissedFullScreenContent`), the reference is cleared, and `loadInterstitialAd()` is called automatically to fetch the next ad.
*   **Trigger**: A public method `showInterstitialAd()` is exposed to trigger the fullscreen ad whenever desired.

---

## 🔒 Release Signing Configurations

The app has release signing configured in [build.gradle.kts](file:///c:/Users/Aditya/OneDrive/Desktop/My%20Apps%20Development/Bubblezilla/app/build.gradle.kts):
*   **Store File**: `bubblee_zilla.jks` (located in the `app/` folder)
*   **Store Password**: `password`
*   **Key Alias**: `upload`
*   **Key Password**: `password`

---

## 🧩 Extension & Future Implementations

To scale this application, we should consider implementing:
1.  **State Management**: Introduce ViewModels (e.g., using `androidx.lifecycle:lifecycle-viewmodel-compose`) to decouple the UI from UI logic in `MainActivity.kt`.
2.  **Navigation**: Implement Compose Navigation to build multi-screen flows.
3.  **Ad Triggering Events**: Hook `showInterstitialAd()` up to page transition actions, button clicks, or custom event states.
4.  **Consent SDK (UMP)**: Add Google User Messaging Platform (UMP) SDK for GDPR / CCPA consent management.
