package com.pumpkinpie65.pocketsign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.pumpkinpie65.pocketsign.input.InputScreen
import com.pumpkinpie65.pocketsign.theme.PocketSignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PocketSignTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    InputScreen(
                        text = "TYPE HERE",
                        onTextChange = {},
                        onShow = {},
                    )
                }
            }
        }
    }
}
