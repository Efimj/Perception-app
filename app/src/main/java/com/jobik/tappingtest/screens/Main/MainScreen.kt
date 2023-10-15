package com.jobik.tappingtest.screens.Main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jobik.tappingtest.ui.theme.CustomTheme

@Composable
fun MainScreen(navController: NavController) {
    LazyColumn(modifier = Modifier.fillMaxSize().background(CustomTheme.Colors.mainBackground)) {
        repeat(100) {
            item {
                Row(
                    modifier = Modifier.padding(20.dp)
                        .background(CustomTheme.Colors.secondaryBackground).fillMaxWidth()
                        .height(20.dp)

                ) {


                }
            }
        }
    }
}