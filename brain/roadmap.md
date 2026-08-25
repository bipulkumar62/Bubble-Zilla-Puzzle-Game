# Product Roadmap — Bubblezilla

A living document tracking planned features, improvements, and milestones. Ordered by priority.

---

## ✅ Completed (v1.0.7 — Current)

- [x] Android Jetpack Compose + Material 3 UI setup
- [x] Edge-to-Edge display support
- [x] Custom `BubblezillaTheme` (Color, Typography, Shapes)
- [x] Google AdMob Banner Ad integration
- [x] Google AdMob Interstitial Ad integration with auto-preload
- [x] Release signing with keystore

---

## 🔜 Upcoming — v1.1.0

- [ ] **Core Gameplay**: Implement bubble spawning and pop mechanics on a Compose Canvas.
- [ ] **Score System**: Real-time score counter displayed on screen.
- [ ] **ViewModels**: Migrate game state (score, lives) out of `MainActivity` into `GameViewModel`.
- [ ] **High Score**: Persist best score locally using `SharedPreferences` or `DataStore`.

---

## 🗓 Mid-term — v1.2.0

- [ ] **Levels / Difficulty**: Progressive speed & spawn rate increasing per level.
- [ ] **Interstitial Triggers**: Hook interstitials to game-over screen and level-complete events.
- [ ] **Sound FX**: Add bubble pop sound using `MediaPlayer` or `SoundPool`.
- [ ] **Animations**: Spring/bounce animations for bubble spawn and pop.

---

## 🌐 Long-term — v2.0.0

- [ ] **Navigation**: Multi-screen flow — Splash → Main Menu → Game → Game Over.
- [ ] **Leaderboards**: Google Play Games Services integration.
- [ ] **GDPR Consent (UMP)**: Google User Messaging Platform for EU compliance.
- [ ] **Rewarded Ads**: Optional rewarded video in exchange for extra lives.
- [ ] **Remove Ads IAP**: One-time in-app purchase to disable banner ads.
- [ ] **AdMob Mediation**: Add alternative ad networks for higher eCPM.
