package com.jobik.tappingtest.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class CustomThemeColors(
    val active: Color,
    val mainBackground: Color,
    val secondaryBackground: Color,
    val text: Color,
    val textOnActive: Color,
    val textSecondary: Color,
    val stroke: Color,
    val secondaryStroke: Color,
    val modalBackground: Color,
)

object CustomTheme {
    val Colors: CustomThemeColors
        @Composable
        get() = LocalCustomThemeColors.current
}

val LocalCustomThemeColors = staticCompositionLocalOf<CustomThemeColors> {
    error("No colors provided")
}