package com.jobik.tappingtest.screens.Statistics

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.jobik.tappingtest.ui.components.bars.NavigationBottomBar.BottomAppBarHeight
import com.jobik.tappingtest.ui.components.buttons.Button.CustomButton
import com.jobik.tappingtest.ui.theme.CustomTheme

@Composable
fun StatisticsScreen(navController: NavController, viewModel: StatisticsViewModel = hiltViewModel()) {
    val galleryLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
            it?.let {
                viewModel.changeUserImage(it)
            }
        }

    LazyColumn(
        modifier = Modifier.fillMaxSize().background(CustomTheme.Colors.mainBackground),
        contentPadding = PaddingValues(
            start = 20.dp,
            end = 20.dp,
            top = 20.dp,
            bottom = (BottomAppBarHeight + 40).dp
        )
    ) {
        item {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                AsyncImage(
                    model = viewModel.screenState.value.userImageUri,
                    contentDescription = "user image",
                    modifier = Modifier.size(180.dp).clip(CircleShape)
                        .background(CustomTheme.Colors.secondaryBackground),
                    contentScale = ContentScale.Crop
                )
                Box(modifier = Modifier.align(Alignment.CenterEnd)) {
                    Column(
                        modifier = Modifier.clip(CustomTheme.Shapes.medium)
                            .background(CustomTheme.Colors.secondaryBackground).border(
                                BorderStroke(width = 1.dp, color = CustomTheme.Colors.stroke),
                                CustomTheme.Shapes.medium
                            ),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CustomButton(
                            icon = Icons.Default.Edit,
                            modifier = Modifier.width(50.dp).height(50.dp),
                            contentPadding = PaddingValues(0.dp),
                            shape = CustomTheme.Shapes.medium,
                            contentColor = CustomTheme.Colors.textSecondary,
                            onClick = { galleryLauncher.launch("image/*") }
                        )
                        HorizontalDivider(
                            modifier = Modifier.width(30.dp).padding(vertical = 4.dp),
                            color = CustomTheme.Colors.stroke
                        )
                        CustomButton(
                            icon = Icons.Outlined.Share,
                            modifier = Modifier.width(50.dp).height(50.dp),
                            contentPadding = PaddingValues(0.dp),
                            shape = CustomTheme.Shapes.medium,
                            contentColor = CustomTheme.Colors.textSecondary,
                            onClick = { }
                        )
                    }
                }
            }
        }
        item { Spacer(modifier = Modifier.height(20.dp)) }
        item {
            Card(
                modifier = Modifier.fillMaxWidth(.7f).height(180.dp),
                colors = CardDefaults.cardColors(
                    contentColor = CustomTheme.Colors.text,
                    containerColor = CustomTheme.Colors.secondaryBackground
                ),
                shape = CustomTheme.Shapes.large
            ) {

            }
        }
    }
}