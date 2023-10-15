package com.jobik.tappingtest.screens.Statistics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.jobik.tappingtest.ui.theme.CustomTheme

@Composable
fun StatisticsScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize().background(CustomTheme.Colors.mainBackground)) {
        Text(text = "StatisticsScreen", color = CustomTheme.Colors.text)
    }
}