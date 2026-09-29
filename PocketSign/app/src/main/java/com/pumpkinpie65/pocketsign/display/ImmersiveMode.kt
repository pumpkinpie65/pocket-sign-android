package com.pumpkinpie65.pocketsign.display

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

/** Hides system bars and keeps the screen on while [enabled]. */
@Composable
fun ImmersiveMode(enabled: Boolean) {
    val view = LocalView.current

    DisposableEffect(enabled) {
        val window = (view.context as ComponentActivity).window
        val controller = WindowCompat.getInsetsController(window, view)

        if (enabled) {
            controller.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            controller.hide(WindowInsetsCompat.Type.systemBars())
            view.keepScreenOn = true
        } else {
            controller.show(WindowInsetsCompat.Type.systemBars())
            view.keepScreenOn = false
        }

        onDispose {
            controller.show(WindowInsetsCompat.Type.systemBars())
            view.keepScreenOn = false
        }
    }
}
