# API & Integration Reference — Bubblezilla

Documentation for all external APIs and SDKs used in the project.

---

## 1. Google Mobile Ads SDK (AdMob)

### Maven Dependency
```toml
# gradle/libs.versions.toml
play-services-ads = "24.3.0"
```
```kotlin
// app/build.gradle.kts
implementation(libs.play.services.ads)
```

### Initialization
```kotlin
// MainActivity.kt — onCreate()
MobileAds.initialize(this) {
    loadInterstitialAd()
}
```

---

### 1.1. Banner Ad API

| Parameter | Value |
|-----------|-------|
| **Class** | `com.google.android.gms.ads.AdView` |
| **Ad Size** | `AdSize.BANNER` (320×50 dp) |
| **Unit ID** | `ca-app-pub-5901475569503459/7744523959` |
| **Ad Request** | `AdRequest.Builder().build()` |

**Usage Pattern in Compose**:
```kotlin
AndroidView(
    factory = { adView },
    update = { it.loadAd(AdRequest.Builder().build()) }
)
DisposableEffect(adView) {
    onDispose { adView.destroy() }
}
```

---

### 1.2. Interstitial Ad API

| Parameter | Value |
|-----------|-------|
| **Class** | `com.google.android.gms.ads.interstitial.InterstitialAd` |
| **Load Method** | `InterstitialAd.load(context, adUnitId, request, callback)` |
| **Unit ID** | `ca-app-pub-5901475569503459/6775996569` |
| **Show Method** | `interstitialAd?.show(activity)` |

**Callback Handling**:
```kotlin
object : InterstitialAdLoadCallback() {
    override fun onAdLoaded(ad: InterstitialAd) { /* store reference */ }
    override fun onAdFailedToLoad(error: LoadAdError) { /* handle gracefully */ }
}
```
**Fullscreen Callbacks**:
```kotlin
object : FullScreenContentCallback() {
    override fun onAdDismissedFullScreenContent() { loadInterstitialAd() }
    override fun onAdFailedToShowFullScreenContent(e: AdError) { interstitialAd = null }
}
```

---

## 2. Jetpack Compose APIs Used

| API | Usage |
|-----|-------|
| `AndroidView` | Embeds legacy `AdView` into Compose tree |
| `DisposableEffect` | Runs cleanup (destroy AdView) on Composable dispose |
| `remember` | Caches `AdView` instance across recompositions |
| `LocalContext.current` | Provides Android `Context` inside a Composable |
| `Scaffold` | Provides Material 3 layout structure |
| `enableEdgeToEdge()` | Enables full bleed display using system window insets |
