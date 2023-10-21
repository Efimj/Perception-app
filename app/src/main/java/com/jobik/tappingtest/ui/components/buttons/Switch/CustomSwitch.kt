package com.jobik.tappingtest.ui.components.buttons.Switch

import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.jobik.tappingtest.ui.theme.CustomTheme

@Composable
fun CustomSwitch(active: Boolean, onClick: (Boolean) -> Unit, thumbContent: @Composable() (() -> Unit)?) {
    Switch(
        checked = active,
        onCheckedChange = onClick,
        thumbContent = thumbContent,
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.White,
            checkedTrackColor = CustomTheme.Colors.active,
            checkedIconColor = Color.DarkGray,
            uncheckedThumbColor = CustomTheme.Colors.textSecondary,
            uncheckedTrackColor = CustomTheme.Colors.mainBackground,
            uncheckedIconColor = CustomTheme.Colors.mainBackground,
            uncheckedBorderColor = CustomTheme.Colors.textSecondary

        )
    )
}