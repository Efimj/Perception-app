package com.jobik.tappingtest.ui.components.bars.CustomTopAppBar

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jobik.tappingtest.ui.theme.CustomTheme

const val TopAppBarHeight = 64

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(navController: NavController) {
    TopAppBar(
        modifier = Modifier.clip(RoundedCornerShape(0.dp, 0.dp, 15.dp, 15.dp)),
        title = { Text(text = "Header", color = CustomTheme.Colors.text) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = CustomTheme.Colors.secondaryBackground,
            scrolledContainerColor = CustomTheme.Colors.mainBackground
        )
    )
}