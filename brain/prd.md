# Product Requirements Document (PRD) — Bubblezilla

## 1. Executive Summary
Bubblezilla is a casual, lightweight mobile game for Android designed to provide simple, engaging, and addictive gameplay. It is built as a free-to-play app monetized through standard Google AdMob banner and interstitial advertisements, targeting a broad casual gaming audience.

## 2. Target Audience & User Persona
- **Audience**: Casual mobile gamers of all ages looking for short, offline-capable sessions.
- **User Persona**: A user who wants to play a quick game while waiting or commuting, requiring zero learning curve and instant gratification.

## 3. Product Features
### 3.1. Core Gameplay
- A minimalistic bubble-popping mechanic (or bubble interaction) implemented in a responsive Jetpack Compose canvas.
- Smooth animations and reactive touch controls.

### 3.2. Monetization (AdMob)
- **Banner Ads**: Persistent standard banner advertisement placed unobtrusively at the bottom of the screen.
- **Interstitial Ads**: Full-screen ads triggered during natural breaks (e.g., game over, level transitions) to maximize revenue without severely disrupting user engagement.

## 4. User Experience (UX) Flow
1. **App Launch**: The user opens the app, and Edge-to-Edge display is enabled.
2. **Main Gameplay**: The user sees the gameplay screen. A banner ad loads at the bottom.
3. **Ad Display**: Interstitial ads preload silently in the background and display upon triggering actions.

## 5. Future Roadmap
- **GDPR Compliance**: Integrate the Google User Messaging Platform (UMP) SDK for user consent management.
- **Gamification**: Implement ViewModels for state, high-score tracking, local database storage (Room), and levels.
- **Sound Settings**: Add background music, pop sound effects, and a mute toggle.
