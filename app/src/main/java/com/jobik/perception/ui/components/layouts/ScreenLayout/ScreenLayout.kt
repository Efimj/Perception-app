package com.jobik.perception.ui.components.layouts.ScreenLayout

import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jobik.perception.ui.components.bars.CustomTopAppBar.CustomTopAppBar
import com.jobik.perception.ui.components.bars.CustomTopAppBar.TopAppBarHeight
import com.jobik.perception.ui.components.bars.NavigationBottomBar.BottomAppBarHeight
import com.jobik.perception.ui.components.bars.NavigationBottomBar.NavigationBottomBar
import com.jobik.perception.navigation.AppScreens
import com.jobik.perception.navigation.SetupNavGraph
import com.jobik.perception.ui.theme.CustomTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScrenLayout() {
    val navController = rememberNavController()
    val currentRoute =
        (navController.currentBackStackEntryAsState().value?.destination?.route ?: "").substringBefore("/")
    val isNavigationBarHide = AppScreens.Routes.isNavigationBarRoute(currentRoute)
    val isTopBarHide = AppScreens.Routes.isTopBarRoute(currentRoute)

    val offsetYBottomBar by animateDpAsState(
        if (!isNavigationBarHide) (BottomAppBarHeight).dp else 0.dp,
        animationSpec = TweenSpec(durationMillis = 200), label = ""
    )
    val offsetYTopBar by animateDpAsState(
        if (!isTopBarHide) -(TopAppBarHeight).dp else 0.dp,
        animationSpec = TweenSpec(durationMillis = 200), label = ""
    )

    Box(modifier = Modifier.fillMaxSize().background(CustomTheme.Colors.mainBackground)) {
        Box(modifier = Modifier.fillMaxSize()) {
            SetupNavGraph(navController = navController, AppScreens.MainScreen.route)
        }
        Box(
            modifier = Modifier.offset(y = offsetYTopBar).fillMaxWidth().align(Alignment.TopCenter),
        ) {
            CustomTopAppBar(navController)
        }
        Box(
            modifier = Modifier.offset(y = offsetYBottomBar).fillMaxWidth().align(Alignment.BottomCenter)
        ) {
            NavigationBottomBar(navController)
        }
    }
}



