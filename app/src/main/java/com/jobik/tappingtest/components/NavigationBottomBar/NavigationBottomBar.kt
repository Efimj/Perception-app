package com.jobik.tappingtest.components.NavigationBottomBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.QueryStats
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.jobik.tappingtest.components.Button.CustomButton
import com.jobik.tappingtest.navigation.AppScreens
import com.jobik.tappingtest.ui.theme.CustomTheme

@Composable
fun NavigationBottomBar(
    navController: NavHostController,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Row(
        modifier = Modifier.height(65.dp).fillMaxWidth()
            .clip(shape = RoundedCornerShape(17.dp, 17.dp, 0.dp, 0.dp))
            .background(CustomTheme.Colors.secondaryBackground).padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        CustomButton(
            modifier = Modifier.fillMaxHeight().fillMaxWidth().weight(1f),
            icon = Icons.Outlined.Home,
            onClick = { goToPage(navController = navController, rout = AppScreens.MainScreen.route) },
            isActive = navBackStackEntry?.destination?.route?.substringBefore("/") == AppScreens.MainScreen.route.substringBefore(
                "/"
            ),
            contentDescription = "Main"
        )
        Spacer(modifier = Modifier.width(8.dp))
        CustomButton(
            modifier = Modifier.fillMaxHeight().fillMaxWidth().weight(1f),
            icon = Icons.Outlined.QueryStats,
            onClick = { goToPage(navController = navController, rout = AppScreens.Statistics.route) },
            isActive = navBackStackEntry?.destination?.route?.substringBefore("/") == AppScreens.Statistics.route.substringBefore(
                "/"
            ),
            contentDescription = "Statistics"
        )
        Spacer(modifier = Modifier.width(8.dp))
        CustomButton(
            modifier = Modifier.fillMaxHeight().fillMaxWidth().weight(1f),
            icon = Icons.Outlined.Settings,
            onClick = { goToPage(navController = navController, rout = AppScreens.Settings.route) },
            isActive = navBackStackEntry?.destination?.route?.substringBefore("/") == AppScreens.Settings.route.substringBefore(
                "/"
            ),
            contentDescription = "Settings"
        )
    }
}

private fun goToPage(
    navController: NavHostController,
    rout: String,
) {
    if (navController.currentDestination?.route?.substringBefore("/") == rout.substringBefore("/")) {
        return
    }
    navController.navigate(rout) { launchSingleTop }
}