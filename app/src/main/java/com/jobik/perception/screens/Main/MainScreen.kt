package com.jobik.perception.screens.Main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jobik.perception.R
import com.jobik.perception.database.entities.TestDuration
import com.jobik.perception.ui.components.cards.TestPreviewCard.TestDescription
import com.jobik.perception.ui.components.cards.TestPreviewCard.TestPreviewCard
import com.jobik.perception.navigation.AppScreens
import com.jobik.perception.ui.components.bars.NavigationBottomBar.BottomAppBarHeight
import com.jobik.perception.ui.theme.CustomTheme

@Composable
fun MainScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().background(CustomTheme.Colors.mainBackground),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(
            start = 10.dp,
            end = 10.dp,
            top = 10.dp,
            bottom = (BottomAppBarHeight + 40).dp
        )
    ) {
        item {
            TestPreviewCard(
                modifier = Modifier.widthIn(max = 500.dp),
                testDescription = TestDescription(
                    title = stringResource(R.string.tapping_test_name),
                    description = stringResource(R.string.tapping_test_description),
                    completionCount = 0,
                    testDuration = TestDuration.QUICK
                )
            ) {
                navController.navigate(AppScreens.TappingTestScreen.route)
            }
        }
    }
}