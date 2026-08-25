# Monetization Strategy — Bubblezilla

## 1. Overview
Bubblezilla is a free-to-play Android app monetized exclusively through **Google AdMob** display advertising. No in-app purchases (IAPs) or subscriptions are currently implemented.

---

## 2. Ad Unit Configuration

| Ad Type | Unit ID | Placement |
|---------|---------|-----------|
| **Banner** | `ca-app-pub-5901475569503459/7744523959` | Bottom of screen (persistent) |
| **Interstitial** | `ca-app-pub-5901475569503459/6775996569` | Full-screen at natural breaks |
| **App (AdMob App ID)** | `ca-app-pub-5901475569503459~5686983705` | Declared in `AndroidManifest.xml` |

---

## 3. Ad Integration Implementation

### Banner Ad
- Implemented as a **Compose-native Composable** (`BannerAd.kt`) using `AndroidView` wrapper.
- Uses `AdSize.BANNER` (320×50 dp standard size).
- Loaded via `AdRequest.Builder().build()` in the `update` block of `AndroidView`.
- Lifecycle safety guaranteed via `DisposableEffect → adView.destroy()`.

### Interstitial Ad
- **Preloading**: Loaded in the background immediately after `MobileAds.initialize()` completes.
- **Chaining**: After every display/dismiss event, the next ad is pre-requested automatically.
- **Triggering**: Called via `showInterstitialAd()` function in `MainActivity`.

---

## 4. Revenue Optimization Tips

- 🔄 **Keep interstitials preloaded** — reduces latency and increases fill rate.
- 📊 **Use AdMob Mediation** — integrate additional ad networks (Meta Audience Network, AppLovin) to increase competition and eCPM.
- 🎯 **Frequency Caps** — avoid showing interstitials more than once every 60–120 seconds to reduce churn.
- 🌍 **UMP Consent (GDPR)** — show personalized ads to EU users only after consent; this significantly affects CPM in European markets.

---

## 5. Future Monetization Opportunities

- **Rewarded Ads**: Show rewarded video ads in exchange for game benefits (extra lives, hints, etc.).
- **Remove Ads IAP**: Offer a one-time purchase to hide banner ads.
- **Google Play Pass**: Opt in to Play Pass for subscription-based revenue.
