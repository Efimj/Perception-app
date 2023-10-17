package com.jobik.tappingtest.screens.Settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.outlined.Brightness6
import androidx.compose.material.icons.outlined.LightMode
import androidx.compose.material3.Icon
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jobik.tappingtest.ui.components.buttons.Switch.CustomSwitch
import com.jobik.tappingtest.ui.components.cards.SettingsItem.SettingsItem
import com.jobik.tappingtest.ui.theme.CustomTheme
import com.jobik.tappingtest.ui.theme.PageContentPadding
import com.jobik.tappingtest.utils.ThemeUtil.ThemeUtil

@Composable
fun SettingsScreen(navController: NavController) {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize().background(CustomTheme.Colors.mainBackground).padding(PageContentPadding)
    ) {
        SettingsItem(
            icon = Icons.Outlined.Brightness6,
            title = "Dark mode",
            description = if (ThemeUtil.isDarkMode.value == true) "Enabled" else "Disabled",
            onClick = { ThemeUtil.saveThemeMode(context, !(ThemeUtil.isDarkMode.value ?: false)) }
        ) {
            CustomSwitch(
                active = ThemeUtil.isDarkMode.value ?: false,
                onClick = { ThemeUtil.saveThemeMode(context, !(ThemeUtil.isDarkMode.value ?: false)) },
                thumbContent = if (ThemeUtil.isDarkMode.value == true) {
                    {
                        Icon(
                            imageVector = Icons.Outlined.LightMode,
                            contentDescription = null,
                            modifier = Modifier.size(SwitchDefaults.IconSize),
                        )
                    }
                } else {
                    {
                        Icon(
                            imageVector = Icons.Default.DarkMode,
                            contentDescription = null,
                            modifier = Modifier.size(SwitchDefaults.IconSize),
                        )
                    }
                })
        }
    }
}

