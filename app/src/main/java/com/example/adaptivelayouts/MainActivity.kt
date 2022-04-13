package com.example.adaptivelayouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import com.example.adaptivelayouts.ui.navigation.AdaptiveLayoutsApp
import com.example.adaptivelayouts.ui.utils.LocalWindowsSize
import com.example.adaptivelayouts.ui.utils.rememberWindowSizeClass

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val windowSize = rememberWindowSizeClass()

            CompositionLocalProvider(LocalWindowsSize provides windowSize) {
                AdaptiveLayoutsApp()
            }
        }
    }
}