package com.jobik.tappingtest.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape

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

data class CustomThemeShapes(
    val none: Shape,
    val small: Shape,
    val medium: Shape,
    val large: Shape,
)

object CustomTheme {
    val Colors: CustomThemeColors
        @Composable
        get() = LocalCustomThemeColors.current
    val Shapes: CustomThemeShapes
        @Composable
        get() = LocalCustomThemeShapes.current
}

val LocalCustomThemeColors = staticCompositionLocalOf<CustomThemeColors> {
    error("No colors provided")
}

val LocalCustomThemeShapes = staticCompositionLocalOf<CustomThemeShapes> {
    error("No shapes provided")
}