package com.jobik.tappingtest.components.ScreenLayout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.compose.rememberNavController
import com.jobik.tappingtest.components.CustomTopAppBar.CustomTopAppBar
import com.jobik.tappingtest.components.NavigationBottomBar.NavigationBottomBar
import com.jobik.tappingtest.navigation.AppScreens
import com.jobik.tappingtest.navigation.SetupNavGraph
import com.jobik.tappingtest.ui.theme.CustomTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScrenLayout() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize().nestedScroll(scrollBehavior.nestedScrollConnection),
        containerColor = CustomTheme.Colors.mainBackground,
        topBar = { CustomTopAppBar(scrollBehavior, navController) },
        bottomBar = { NavigationBottomBar(navController) }
    ) {
        Box(modifier = Modifier.fillMaxSize().padding(it)) {
            SetupNavGraph(navController = navController, AppScreens.MainScreen.route)
        }
    }
}



