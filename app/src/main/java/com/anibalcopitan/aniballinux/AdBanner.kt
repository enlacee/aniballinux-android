package com.anibalcopitan.aniballinux

import android.util.Log
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.anibalcopitan.aniballinux.ui.theme.MyLinuxTheme
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

@Composable
fun BannerAd() {

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Publicidad",
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 4.dp)
        )

        AndroidView(
            factory = { context ->

                AdView(context).apply {

                    //------
                    // 1. create a new ad view
                    //------
                    // Usamos el ID inyectado por Gradle dependiendo del entorno actual
                    adUnitId = BuildConfig.ADMOB_BANNER_ID

                    //------
                    // 2. set the with of anchored adaptative banner to 360
                    // ------
                    //  setAdSize(AdSize.BANNER)
                    // Dentro de tu factory en AdBanner.kt
                    val displayMetrics = context.resources.displayMetrics
                    val widthPixels = displayMetrics.widthPixels
                    val adWidth = (widthPixels / displayMetrics.density).toInt()

                    setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(context, adWidth))
//                  setAdSize(AdSize.getCurrentOrientationInlineAdaptiveBannerAdSize(context, 360))


                    //------
                    // 3. optional add lister
                    //------
                    // adListener
                    adListener = object: AdListener(){
                        override fun onAdImpression() {
                            Log.e("ADS AdMob", "Ad logged an impression")
                        }
                    }

                    //------
                    // 4. load an ad
                    //------
                    loadAd(AdRequest.Builder().build())

                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BannerAdPreview() {
    MyLinuxTheme {
        BannerAd()
    }
}