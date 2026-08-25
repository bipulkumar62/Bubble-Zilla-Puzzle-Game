# Technical Requirements Document (TRD) — Bubblezilla

## 1. System Requirements & Platform SDKs
- **Target OS**: Android (Minimum SDK `24` / Android 7.0, Target SDK `35` / Android 15, Compile SDK `36` / Android 16)
- **Language**: Kotlin `2.0.21` with Kotlin Compose Compiler enabled.
- **Build System**: Gradle Kotlin DSL (`build.gradle.kts` configuration format).

## 2. Dependency Specification
All dependency versions are managed globally via a Gradle Version Catalog at `gradle/libs.versions.toml`.

Key libraries include:
- **Jetpack Compose BOM**: `2024.09.00`
- **Material Design 3**: `androidx.compose.material3:material3`
- **Google Play Services Ads**: `com.google.android.gms:play-services-ads:24.3.0`
- **Activity Compose**: `androidx.activity:activity-compose:1.13.0`

## 3. Integration Details
### 3.1. Google Mobile Ads (AdMob)
- **AndroidManifest.xml Settings**:
  - Contains `<meta-data>` entry specifying the AdMob Application ID: `ca-app-pub-5901475569503459~5686983705`.
- **String Resources (`strings.xml`)**:
  - Banner Ad Unit: `ca-app-pub-5901475569503459/7744523959`
  - Interstitial Ad Unit: `ca-app-pub-5901475569503459/6775996569`

## 4. Production Build & Release Configuration
- **Signing Configurations**:
  - Release build signing is configured inside the module-level `build.gradle.kts`.
  - Keystore alias: `upload`
  - Keystore password: `password`
  - Store file: `bubblee_zilla.jks` (located in the `app/` folder)
- **Code Shrinking & Obfuscation**:
  - Enabled via `isMinifyEnabled = true` and `isShrinkResources = true` in the release build type.
  - Custom rules defined in `proguard-rules.pro`.

## 5. Technical Roadmap Checklist
- [ ] Implement ViewModels (`androidx.lifecycle:lifecycle-viewmodel-compose`).
- [ ] Implement Jetpack Navigation for Compose.
- [ ] Integrate Google User Messaging Platform (UMP) SDK for GDPR consent dialogs.
