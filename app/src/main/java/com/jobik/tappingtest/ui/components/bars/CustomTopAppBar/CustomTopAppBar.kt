package com.jobik.tappingtest.ui.components.bars.CustomTopAppBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.jobik.tappingtest.ui.theme.CustomTheme

const val TopAppBarHeight = 64

@Composable
fun CustomTopAppBar(navController: NavController) {
    Column(
        modifier = Modifier.clip(RoundedCornerShape(0.dp, 0.dp, 15.dp, 15.dp)).height(TopAppBarHeight.dp)
            .background(CustomTheme.Colors.secondaryBackground)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Test app", color = CustomTheme.Colors.text, fontSize = 20.sp)
    }
}