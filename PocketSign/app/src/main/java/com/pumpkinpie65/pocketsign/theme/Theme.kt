package com.pumpkinpie65.pocketsign.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = PumpkinFillingBright,
    onPrimary = OnPumpkinFillingDark,
    primaryContainer = PumpkinFillingContainerDark,
    onPrimaryContainer = PumpkinFillingContainer,
    inversePrimary = PumpkinFilling,
    secondary = CrustBright,
    onSecondary = OnCrustDark,
    secondaryContainer = CrustContainerDark,
    onSecondaryContainer = CrustContainer,
    tertiary = NutmegBright,
    onTertiary = OnNutmegDark,
    tertiaryContainer = NutmegContainerDark,
    onTertiaryContainer = NutmegContainer,
    background = CrustNight,
    onBackground = OnCrustNight,
    surface = CrustNight,
    onSurface = OnCrustNight,
    surfaceVariant = CrustNightVariant,
    onSurfaceVariant = OnCrustNightMuted,
    surfaceTint = PumpkinFillingBright,
    inverseSurface = OnCrustNight,
    inverseOnSurface = OnCream,
    outline = OutlineDark,
    outlineVariant = CrustNightVariant,
    error = ErrorDark,
    onError = OnErrorDark,
    errorContainer = ErrorContainerDark,
    onErrorContainer = OnErrorContainerDark,
)

private val LightColorScheme = lightColorScheme(
    primary = PumpkinFilling,
    onPrimary = OnPumpkinFilling,
    primaryContainer = PumpkinFillingContainer,
    onPrimaryContainer = OnPumpkinFillingDark,
    inversePrimary = PumpkinFillingBright,
    secondary = Crust,
    onSecondary = OnCrust,
    secondaryContainer = CrustContainer,
    onSecondaryContainer = OnCrustDark,
    tertiary = Nutmeg,
    onTertiary = OnNutmeg,
    tertiaryContainer = NutmegContainer,
    onTertiaryContainer = OnNutmegDark,
    background = Cream,
    onBackground = OnCream,
    surface = Cream,
    onSurface = OnCream,
    surfaceVariant = CreamMuted,
    onSurfaceVariant = OnCreamMuted,
    surfaceTint = PumpkinFilling,
    inverseSurface = OnCream,
    inverseOnSurface = OnCrustNight,
    outline = OutlineLight,
    outlineVariant = OutlineVariantLight,
    error = ErrorLight,
    onError = OnErrorLight,
    errorContainer = ErrorContainerLight,
    onErrorContainer = OnErrorContainerLight,
)

@Composable
fun PocketSignTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Wallpaper-based Material You color; off so the pumpkin palette stays in control.
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
