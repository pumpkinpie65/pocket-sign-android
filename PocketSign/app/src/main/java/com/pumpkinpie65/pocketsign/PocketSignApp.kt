package com.pumpkinpie65.pocketsign

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.pumpkinpie65.pocketsign.display.DisplayScreen
import com.pumpkinpie65.pocketsign.display.ImmersiveMode
import com.pumpkinpie65.pocketsign.input.InputScreen

@Composable
fun PocketSignApp() {
    var text by rememberSaveable { mutableStateOf("") }
    var showingDisplay by rememberSaveable { mutableStateOf(false) }

    ImmersiveMode(enabled = showingDisplay)
    BackHandler(enabled = showingDisplay) {
        showingDisplay = false
    }

    if (showingDisplay) {
        DisplayScreen(
            text = text,
            onDismiss = { showingDisplay = false },
        )
    } else {
        InputScreen(
            text = text,
            onTextChange = { text = it },
            onShow = { showingDisplay = true },
        )
    }
}
