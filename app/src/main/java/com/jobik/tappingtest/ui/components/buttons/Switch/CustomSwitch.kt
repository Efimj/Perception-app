package com.jobik.tappingtest.ui.components.buttons.Switch

import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import com.jobik.tappingtest.ui.theme.CustomTheme

@Composable
fun CustomSwitch(active: Boolean, onClick: (Boolean) -> Unit, thumbContent: @Composable() (() -> Unit)?) {
    Switch(
        checked = active,
        onCheckedChange = onClick,
        thumbContent = thumbContent,
        colors = SwitchDefaults.colors(
            checkedThumbColor = CustomTheme.Colors.text,
            checkedTrackColor = CustomTheme.Colors.active,
            checkedIconColor = CustomTheme.Colors.mainBackground,
            uncheckedThumbColor = CustomTheme.Colors.textSecondary,
            uncheckedTrackColor = CustomTheme.Colors.mainBackground,
            uncheckedIconColor = CustomTheme.Colors.mainBackground,
            uncheckedBorderColor = CustomTheme.Colors.textSecondary

        )
    )
}