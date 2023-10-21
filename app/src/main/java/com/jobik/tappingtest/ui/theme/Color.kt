package com.jobik.tappingtest.ui.theme

import androidx.compose.ui.graphics.Color

val baseLightColors = CustomThemeColors(
    active = Color(0xFF4284f5),
    mainBackground = Color(0xFFECEEEF),
    secondaryBackground = Color(0xFFFFFFFF),
    stroke = Color(0xFFD2D2D2),
    secondaryStroke = Color(0xFFD2D2D2),
    text = Color(0xFF161616),
    textOnActive = Color(0xFFFFFFFF),
    textSecondary = Color(0xFF7A7A7A),
    modalBackground = Color(0, 0, 0, (255 * 0.2).toInt()),
)

val baseDarkColors = CustomThemeColors(
    active = Color(0xFF4284f5),
    mainBackground = Color(0xFF0F0F0F),
    secondaryBackground = Color(0xFF191919),
    stroke = Color(0xFF404040),
    secondaryStroke = Color(0xFF404040),
    text = Color(0xFFFFFFFF),
    textOnActive = Color(0xFFFFFFFF),
    textSecondary = Color(0xFF959595),
    modalBackground = Color(0, 0, 0, (255 * 0.4).toInt()),
)
