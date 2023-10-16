package com.jobik.tappingtest.ui.theme

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp
import com.jobik.tappingtest.ui.components.bars.CustomTopAppBar.TopAppBarHeight
import com.jobik.tappingtest.ui.components.bars.NavigationBottomBar.BottomAppBarHeight

val PageContentPadding = PaddingValues(
    start = 0.dp,
    end = 0.dp,
    top = (TopAppBarHeight + 10).dp,
    bottom = (BottomAppBarHeight + 40).dp
)

val PageListContentPadding = PaddingValues(
    start = 10.dp,
    end = 10.dp,
    top = (TopAppBarHeight + 10).dp,
    bottom = (BottomAppBarHeight + 40).dp
)