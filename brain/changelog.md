# Changelog — Bubblezilla

All notable changes to this project will be documented in this file.
Follows [Keep a Changelog](https://keepachangelog.com/en/1.0.0/) format.

---

## [1.0.7] — Current
### Added
- Production AdMob Banner & Interstitial Ad Units configured.
- Release signing with `bubblee_zilla.jks` keystore.
- Auto-preload interstitial ad after dismissal.

### Changed
- Upgraded Compile SDK to `36` (Android 16).

---

## [1.0.6]
### Added
- `BannerAd` Composable with lifecycle-safe `DisposableEffect`.
- `onDestroy()` cleanup for interstitial ad reference in `MainActivity`.

---

## [1.0.5]
### Added
- Initial interstitial ad integration with `InterstitialAdLoadCallback`.
- `showInterstitialAd()` public method exposed on `MainActivity`.

---

## [1.0.1] — Initial Release
### Added
- Project created with Jetpack Compose + Material 3 template.
- Edge-to-Edge display support enabled.
- `BubblezillaTheme` custom theme setup with `Color.kt`, `Theme.kt`, `Type.kt`.
- `MobileAds.initialize()` integrated in `onCreate`.
