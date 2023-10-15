package com.jobik.tappingtest.components.ScreenLayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.QueryStats
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jobik.tappingtest.components.Button.CustomButton
import com.jobik.tappingtest.navigation.AppScreens
import com.jobik.tappingtest.navigation.SetupNavGraph
import com.jobik.tappingtest.ui.theme.CustomTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScrenLayout() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize().nestedScroll(scrollBehavior.nestedScrollConnection),
        containerColor = CustomTheme.Colors.mainBackground,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Text", color = CustomTheme.Colors.text)
                },
                scrollBehavior = scrollBehavior,
                colors = TopAppBarDefaults.topAppBarColors(containerColor = CustomTheme.Colors.secondaryBackground)
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier.height(65.dp).fillMaxWidth()
                    .clip(shape = RoundedCornerShape(17.dp, 17.dp, 0.dp, 0.dp))
                    .background(CustomTheme.Colors.secondaryBackground).padding(8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                CustomButton(
                    modifier = Modifier.fillMaxHeight().fillMaxWidth().weight(1f),
                    text = "Main",
                    icon = Icons.Outlined.Home,
                    onClick = { goToPage(navController = navController, rout = AppScreens.MainScreen.route) },
                    isActive = navBackStackEntry?.destination?.route?.substringBefore("/") == AppScreens.MainScreen.route.substringBefore(
                        "/"
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                CustomButton(
                    modifier = Modifier.fillMaxHeight().fillMaxWidth().weight(1f),
                    text = "Statistics",
                    icon = Icons.Outlined.QueryStats,
                    onClick = { goToPage(navController = navController, rout = AppScreens.Statistics.route) },
                    isActive = navBackStackEntry?.destination?.route?.substringBefore("/") == AppScreens.Statistics.route.substringBefore(
                        "/"
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                CustomButton(
                    modifier = Modifier.fillMaxHeight().fillMaxWidth().weight(1f),
                    text = "Settings",
                    icon = Icons.Outlined.Settings,
                    onClick = { goToPage(navController = navController, rout = AppScreens.Settings.route) },
                    isActive = navBackStackEntry?.destination?.route?.substringBefore("/") == AppScreens.Settings.route.substringBefore(
                        "/"
                    )
                )
            }
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            SetupNavGraph(navController = navController, AppScreens.MainScreen.route)
        }
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