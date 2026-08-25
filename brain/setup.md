# Developer Setup Guide — Bubblezilla

A step-by-step guide to setting up the development environment and building the project locally.

---

## 1. Prerequisites

| Tool | Version |
|------|---------|
| Android Studio | Hedgehog or newer |
| JDK | 17+ |
| Gradle | 8.x (via wrapper) |
| Android SDK | Platform `35`, Build Tools `36.0.0` |

---

## 2. Clone & Open

```bash
# Clone the repository
git clone <repository-url>

# Open in Android Studio
# File → Open → Select the Bubblezilla/ folder
```

---

## 3. Configure `local.properties`

Ensure the file at the project root contains:
```properties
sdk.dir=C\:\\Users\\<YOUR_USERNAME>\\AppData\\Local\\Android\\Sdk
```
This file is **git-ignored** and must be created manually on each machine.

---

## 4. Signing Configuration

For **release builds**, the signing credentials are already embedded in `app/build.gradle.kts`:
- **Keystore**: `app/bubblee_zilla.jks`
- **Alias**: `upload`
- **Store Password**: `password`
- **Key Password**: `password`

> ⚠️ Do NOT commit real production credentials to source control. Replace these with environment variables or a secrets manager in CI/CD pipelines.

---

## 5. AdMob Test Ads (Development)

When developing locally, use **AdMob test Ad Unit IDs** to avoid invalid traffic policy violations.

| Ad Type | Test Unit ID |
|---------|-------------|
| Banner | `ca-app-pub-3940256099942544/6300978111` |
| Interstitial | `ca-app-pub-3940256099942544/1033173712` |

Replace the production IDs in `strings.xml` with these test IDs during development, then swap them back before release.

---

## 6. Build & Run

```bash
# Build debug APK via Gradle wrapper
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease

# Install on connected device
./gradlew installDebug
```

Or use **Android Studio** ▶ Run button to build and deploy directly.

---

## 7. Code Quality Checks

```bash
# Run lint checks
./gradlew lint

# Run all checks and tests
./gradlew check
```
