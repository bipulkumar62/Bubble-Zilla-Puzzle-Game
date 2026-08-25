package com.startupzilla.bubblezilla

import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.unit.dp
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.startupzilla.bubblezilla.ui.theme.BubblezillaTheme

class MainActivity : ComponentActivity() {

    private var interstitialAd: InterstitialAd? = null
    private var gamesPlayed = mutableIntStateOf(0)
    private var bestScore = mutableIntStateOf(0)
    private var gameOversSinceInterstitial = 0
    private var lastInterstitialShownAt = 0L

    private val statsPrefs by lazy {
        getSharedPreferences("bubblezilla_stats", MODE_PRIVATE)
    }

    private companion object {
        const val MIN_INTERSTITIAL_INTERVAL_MS = 120_000L
        const val GAME_OVERS_BETWEEN_INTERSTITIALS = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        gamesPlayed.intValue = statsPrefs.getInt("games_played", 0)
        bestScore.intValue = statsPrefs.getInt("best_score", 0)

        // Initialize AdMob
        MobileAds.initialize(this) {
            loadInterstitialAd()
        }

        setContent {
            BubblezillaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        GoalTracker(
                            gamesPlayed = gamesPlayed.intValue,
                            bestScore = bestScore.intValue,
                            modifier = Modifier.fillMaxWidth()
                        )
                        BubblezillaGame(
                            onGameOver = { finalScore ->
                                runOnUiThread {
                                    recordGameOver(finalScore)
                                    showInterstitialAdIfReady()
                                }
                            },
                            modifier = Modifier.weight(1f)
                        )
                        BannerAd(
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }

    private fun loadInterstitialAd() {
        val adUnitId = getString(R.string.interstitial_ad_unit_id)
        InterstitialAd.load(this, adUnitId, AdRequest.Builder().build(), object : InterstitialAdLoadCallback() {
            override fun onAdLoaded(ad: InterstitialAd) {
                interstitialAd = ad
                interstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
                    override fun onAdDismissedFullScreenContent() {
                        interstitialAd = null
                        loadInterstitialAd() // Preload next ad
                    }

                    override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                        interstitialAd = null
                        loadInterstitialAd()
                    }
                }
            }

            override fun onAdFailedToLoad(adError: LoadAdError) {
                interstitialAd = null
            }
        })
    }

    private fun recordGameOver(finalScore: Int) {
        gamesPlayed.intValue += 1
        if (finalScore > bestScore.intValue) {
            bestScore.intValue = finalScore
        }

        statsPrefs.edit()
            .putInt("games_played", gamesPlayed.intValue)
            .putInt("best_score", bestScore.intValue)
            .apply()
    }

    private fun showInterstitialAdIfReady() {
        gameOversSinceInterstitial += 1
        val now = System.currentTimeMillis()
        val enoughGameOvers = gameOversSinceInterstitial >= GAME_OVERS_BETWEEN_INTERSTITIALS
        val enoughTime = now - lastInterstitialShownAt >= MIN_INTERSTITIAL_INTERVAL_MS
        val ad = interstitialAd

        if (ad != null && enoughGameOvers && enoughTime) {
            gameOversSinceInterstitial = 0
            lastInterstitialShownAt = now
            ad.show(this)
        }
    }

    override fun onDestroy() {
        interstitialAd?.fullScreenContentCallback = null
        interstitialAd = null
        super.onDestroy()
    }

}

@Composable
fun GoalTracker(
    gamesPlayed: Int,
    bestScore: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.surface)
            .padding(horizontal = 16.dp, vertical = 10.dp)
    ) {
        Text(
            text = "Bubblezilla",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TrackerMetric(label = "Goal", value = "\$10")
            TrackerMetric(label = "Plays", value = gamesPlayed.toString())
            TrackerMetric(label = "Best", value = bestScore.toString())
        }
        Text(
            text = "AdMob dashboard is the source of truth for real earnings.",
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(top = 6.dp)
        )
    }
}

@Composable
fun TrackerMetric(label: String, value: String) {
    Column {
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = value,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun BubblezillaGame(
    onGameOver: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    AndroidView(
        modifier = modifier.fillMaxWidth(),
        factory = { context ->
            WebView(context).apply {
                webViewClient = WebViewClient()
                settings.javaScriptEnabled = true
                settings.domStorageEnabled = true
                settings.mediaPlaybackRequiresUserGesture = false
                addJavascriptInterface(
                    object {
                        @JavascriptInterface
                        fun onGameOver(finalScore: Int) {
                            onGameOver(finalScore)
                        }
                    },
                    "BubblezillaAndroid"
                )
                loadUrl("file:///android_asset/bubblezilla_game.html")
            }
        },
        update = { webView ->
            if (webView.url == null) {
                webView.loadUrl("file:///android_asset/bubblezilla_game.html")
            }
        },
        onRelease = { webView ->
            webView.stopLoading()
            webView.removeJavascriptInterface("BubblezillaAndroid")
            webView.destroy()
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BubblezillaTheme {
        GoalTracker(gamesPlayed = 12, bestScore = 420)
    }
}
