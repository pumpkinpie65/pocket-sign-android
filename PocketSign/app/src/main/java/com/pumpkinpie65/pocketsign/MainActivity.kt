package com.pumpkinpie65.pocketsign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.pumpkinpie65.pocketsign.theme.PocketSignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PocketSignTheme {
                PocketSignApp()
            }
        }
    }
}
