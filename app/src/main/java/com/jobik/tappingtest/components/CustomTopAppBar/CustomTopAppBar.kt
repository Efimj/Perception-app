package com.jobik.tappingtest.components.CustomTopAppBar

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.jobik.tappingtest.ui.theme.CustomTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(scrollBehavior: TopAppBarScrollBehavior, navController: NavController) {
    TopAppBar(
        title = {
            Text(text = "Text", color = CustomTheme.Colors.text)
        },
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.topAppBarColors(containerColor = CustomTheme.Colors.secondaryBackground)
    )
}