package com.jobik.tappingtest.ui.components.charts

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jobik.tappingtest.ui.theme.CustomTheme
import com.patrykandpatrick.vico.compose.axis.horizontal.rememberBottomAxis
import com.patrykandpatrick.vico.compose.axis.vertical.rememberStartAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.layout.fullWidth
import com.patrykandpatrick.vico.compose.chart.line.lineChart
import com.patrykandpatrick.vico.compose.component.shape.shader.fromBrush
import com.patrykandpatrick.vico.compose.component.textComponent
import com.patrykandpatrick.vico.compose.dimensions.dimensionsOf
import com.patrykandpatrick.vico.core.DefaultAlpha
import com.patrykandpatrick.vico.core.axis.AxisItemPlacer
import com.patrykandpatrick.vico.core.chart.layout.HorizontalLayout
import com.patrykandpatrick.vico.core.chart.line.LineChart
import com.patrykandpatrick.vico.core.component.shape.LineComponent
import com.patrykandpatrick.vico.core.component.shape.shader.DynamicShaders
import com.patrykandpatrick.vico.core.entry.ChartEntryModel

@Composable
fun CustomLineChart(chartEntryModel: ChartEntryModel, modifier: Modifier = Modifier) {
    Chart(
        modifier = modifier,
        isZoomEnabled = false,
        horizontalLayout = HorizontalLayout.fullWidth(), //HorizontalLayout.fullWidth(startPadding = 5.dp, endPadding = 5.dp),
        chart = lineChart(
            lines = listOf(
                LineChart.LineSpec(
                    lineColor = CustomTheme.Colors.active.toArgb(),
                    lineBackgroundShader = DynamicShaders.fromBrush(
                        brush = Brush.verticalGradient(
                            listOf(
                                CustomTheme.Colors.active.copy(DefaultAlpha.LINE_BACKGROUND_SHADER_START),
                                CustomTheme.Colors.text.copy(DefaultAlpha.LINE_BACKGROUND_SHADER_END)
                            )
                        )
                    )
                )
            )
        ),
        model = chartEntryModel,
        startAxis = rememberStartAxis(
            label = textComponent(
                color = CustomTheme.Colors.textSecondary,
                textSize = 14.sp,
                padding = dimensionsOf(end = 3.dp)
            ),
            tick = LineComponent(
                color = CustomTheme.Colors.stroke.toArgb(),
                thicknessDp = 1.dp.value,
                strokeColor = CustomTheme.Colors.stroke.toArgb(),
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
            itemPlacer = AxisItemPlacer.Vertical.default(maxItemCount = 9)
        ),
        bottomAxis = rememberBottomAxis(
            label = textComponent(
                color = CustomTheme.Colors.textSecondary,
                textSize = 14.sp,
                padding = dimensionsOf(top = 0.dp)
            ),
            tick = LineComponent(
                color = CustomTheme.Colors.stroke.toArgb(),
                thicknessDp = 1.dp.value,
                strokeColor = CustomTheme.Colors.stroke.toArgb(),
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
            itemPlacer = AxisItemPlacer.Horizontal.default()
        ),
    )
}