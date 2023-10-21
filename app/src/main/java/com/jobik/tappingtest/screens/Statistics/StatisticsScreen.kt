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
import com.jobik.tappingtest.ui.components.charts.CustomLineChart
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

    LazyColumn(
        modifier = Modifier.background(CustomTheme.Colors.mainBackground).fillMaxSize(),
        contentPadding = PaddingValues(
            start = 20.dp,
            end = 20.dp,
            top = 20.dp,
            bottom = (BottomAppBarHeight + 40).dp
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Box(modifier = Modifier.widthIn(max = 500.dp).fillMaxWidth(), contentAlignment = Alignment.Center) {
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
                modifier = Modifier.widthIn(max = 500.dp).fillMaxWidth(.9f),
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
        item { Spacer(modifier = Modifier.height(20.dp)) }
        item {
            Card(
                modifier = Modifier.widthIn(max = 500.dp).fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    contentColor = CustomTheme.Colors.text,
                    containerColor = CustomTheme.Colors.secondaryBackground
                ),
                shape = CustomTheme.Shapes.large
            ) {
                val chartEntryModel =
                    entryModelOf(
                        *(addIntermediatePoints(
                            points = listOf(4f, 12f, 8f, 16f),
                            desiredSize = 10
                        ).toTypedArray())
                    )
                CustomLineChart(chartEntryModel = chartEntryModel, modifier = Modifier.padding(12.dp))
            }
        }
    }
}

fun addIntermediatePoints(points: List<Float>, desiredSize: Int): List<Float> {
    if (points.size < 2 || desiredSize <= 0) {
        return emptyList()
    }

    val interpolatedPoints = mutableListOf<Float>()

    val step = (points.size - 1).toFloat() / (desiredSize - 1)
    for (i in 0 until desiredSize) {
        val index1 = (i * step).toInt()
        val index2 = (index1 + 1).coerceAtMost(points.size - 1)
        val t = i * step - index1
        val interpolatedValue = points[index1] + t * (points[index2] - points[index1])
        interpolatedPoints.add(interpolatedValue)
    }

    return interpolatedPoints
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