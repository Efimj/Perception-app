package com.jobik.tappingtest.components.CustomTopAppBar

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.jobik.tappingtest.navigation.AppScreens
import com.jobik.tappingtest.ui.theme.CustomTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(scrollBehavior: TopAppBarScrollBehavior, navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val isHiding =
        navBackStackEntry?.destination?.route?.substringBefore("/") == AppScreens.MainScreen.route.substringBefore(
            "/"
        )

    TopAppBar(
        modifier = Modifier.clip(RoundedCornerShape(0.dp, 0.dp, 15.dp, 15.dp)),
        title = { Text(text = "Header", color = CustomTheme.Colors.text) },
        scrollBehavior = if (isHiding) scrollBehavior else null,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = CustomTheme.Colors.secondaryBackground,
            scrolledContainerColor = CustomTheme.Colors.mainBackground
        )
    )
}