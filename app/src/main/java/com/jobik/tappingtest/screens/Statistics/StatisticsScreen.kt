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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.size.Dimension
import com.jobik.tappingtest.ui.components.bars.NavigationBottomBar.BottomAppBarHeight
import com.jobik.tappingtest.ui.components.buttons.Button.CustomButton
import com.jobik.tappingtest.ui.theme.CustomTheme
import com.patrykandpatrick.vico.compose.axis.horizontal.rememberBottomAxis
import com.patrykandpatrick.vico.compose.axis.vertical.rememberStartAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.line.lineChart
import com.patrykandpatrick.vico.compose.component.shape.shader.fromBrush
import com.patrykandpatrick.vico.compose.component.textComponent
import com.patrykandpatrick.vico.compose.dimensions.dimensionsOf
import com.patrykandpatrick.vico.core.chart.dimensions.HorizontalDimensions
import com.patrykandpatrick.vico.core.chart.line.LineChart
import com.patrykandpatrick.vico.core.component.shape.LineComponent
import com.patrykandpatrick.vico.core.component.shape.shader.DynamicShaders
import com.patrykandpatrick.vico.core.component.text.TextComponent
import com.patrykandpatrick.vico.core.component.text.textComponent
import com.patrykandpatrick.vico.core.dimensions.Dimensions
import com.patrykandpatrick.vico.core.entry.entryModelOf

@Composable
fun StatisticsScreen(navController: NavController, viewModel: StatisticsViewModel = hiltViewModel()) {
    val galleryLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
            it?.let {
                viewModel.changeUserImage(it)
            }
        }
    Column(
        modifier = Modifier.fillMaxSize().background(CustomTheme.Colors.mainBackground),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier.widthIn(max = 500.dp).fillMaxSize(),
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
                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Card(
                        modifier = Modifier.fillMaxWidth(.9f),
                        colors = CardDefaults.cardColors(
                            contentColor = CustomTheme.Colors.text,
                            containerColor = CustomTheme.Colors.secondaryBackground
                        ),
                        shape = CustomTheme.Shapes.large
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            ItemCard(header = "Finished", value = "13")
                            ItemCard(header = "Progress", value = "23%")
                            ItemCard(header = "Time", value = "2023m")
                        }
                    }
                }
            }
            item { Spacer(modifier = Modifier.height(20.dp)) }
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        contentColor = CustomTheme.Colors.text,
                        containerColor = CustomTheme.Colors.secondaryBackground
                    ),
                    shape = CustomTheme.Shapes.large
                ) {
                    val chartEntryModel = entryModelOf(4f, 12f, 8f, 16f)
                    Chart(
                        modifier = Modifier.padding(12.dp),
                        chart = lineChart(
                            lines = listOf(
                                LineChart.LineSpec(
                                    lineColor = CustomTheme.Colors.active.toArgb(),
                                    lineBackgroundShader = DynamicShaders.fromBrush(
                                        brush = Brush.verticalGradient(
                                            listOf(
                                                CustomTheme.Colors.active.copy(com.patrykandpatrick.vico.core.DefaultAlpha.LINE_BACKGROUND_SHADER_START),
                                                CustomTheme.Colors.text.copy(com.patrykandpatrick.vico.core.DefaultAlpha.LINE_BACKGROUND_SHADER_END)
                                            )
                                        )
                                    )
                                )
                            )
                        ),
                        model = chartEntryModel,
                        startAxis = rememberStartAxis(
                            label = textComponent(
                                color = CustomTheme.Colors.text,
                                textSize = 14.sp,
                            ),
                            axis = LineComponent(
                                color = CustomTheme.Colors.stroke.toArgb(),
                                thicknessDp = 1.dp.value,
                                strokeColor = CustomTheme.Colors.stroke.toArgb(),
                            ),
                            guideline = LineComponent(
                                color = CustomTheme.Colors.stroke.toArgb(),
                                thicknessDp = 1.dp.value,
                            ),
                        ),
                        bottomAxis = rememberBottomAxis(
                            label = textComponent(
                                color = CustomTheme.Colors.text,
                                textSize = 14.sp,
                            ),
                            axis = LineComponent(
                                color = CustomTheme.Colors.stroke.toArgb(),
                                thicknessDp = 1.dp.value,
                                strokeColor = CustomTheme.Colors.stroke.toArgb(),
                            ),
                            guideline = LineComponent(
                                color = CustomTheme.Colors.stroke.toArgb(),
                                thicknessDp = 1.dp.value,
                            ),
                        ),
                    )
                }
            }
        }
    }
}

@Composable
private fun ItemCard(header: String, value: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 10.dp)
    ) {
        Text(
            text = header,
            fontSize = 18.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = CustomTheme.Colors.textSecondary
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = value,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = CustomTheme.Colors.text
        )
    }
}