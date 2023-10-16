package com.jobik.tappingtest.screens.Main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jobik.tappingtest.ui.components.cards.TestPreviewCard.TestDescription
import com.jobik.tappingtest.ui.components.cards.TestPreviewCard.TestPreviewCard
import com.jobik.tappingtest.navigation.AppScreens
import com.jobik.tappingtest.ui.theme.CustomTheme
import com.jobik.tappingtest.ui.theme.PageListContentPadding

@Composable
fun MainScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().background(CustomTheme.Colors.mainBackground),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PageListContentPadding
    ) {
        item {
            TestPreviewCard(
                testDescription = TestDescription(
                    title = "Tapping test",
                    description = "Определение силы нервной системы",
                    completionCount = 0,
                    passingTime = 5
                )
            ) {
                navController.navigate(AppScreens.TappingTestScreen.route)
            }
        }
        item {
            TestPreviewCard(
                testDescription = TestDescription(
                    title = "Knowledge Challenge",
                    description = "Knowledge Challenge",
                    completionCount = 0,
                    passingTime = 5
                )
            ) {

            }
        }
        item {
            TestPreviewCard(
                testDescription = TestDescription(
                    title = "Test 1",
                    description = "Description for Test 1",
                    completionCount = 10,
                    passingTime = 15
                )
            ) {

            }
        }

        item {
            TestPreviewCard(
                testDescription = TestDescription(
                    title = "Test 2",
                    description = "Description for Test 2",
                    completionCount = 20,
                    passingTime = 10
                )
            ) {

            }
        }

        item {
            TestPreviewCard(
                testDescription = TestDescription(
                    title = "Test 3",
                    description = "Description for Test 3",
                    completionCount = 5,
                    passingTime = 8
                )
            ) {

            }
        }

        item {
            TestPreviewCard(
                testDescription = TestDescription(
                    title = "Test 4",
                    description = "Description for Test 4",
                    completionCount = 15,
                    passingTime = 12
                )
            ) {

            }
        }

        item {
            TestPreviewCard(
                testDescription = TestDescription(
                    title = "Test 5",
                    description = "Description for Test 5",
                    completionCount = 0,
                    passingTime = 20
                )
            ) {

            }
        }

        item {
            TestPreviewCard(
                testDescription = TestDescription(
                    title = "Test 6",
                    description = "Description for Test 6",
                    completionCount = 0,
                    passingTime = 18
                )
            ) {

            }
        }

        item {
            TestPreviewCard(
                testDescription = TestDescription(
                    title = "Test 7",
                    description = "Description for Test 7",
                    completionCount = 8,
                    passingTime = 25
                )
            ) {

            }
        }

        item {
            TestPreviewCard(
                testDescription = TestDescription(
                    title = "Test 8",
                    description = "Description for Test 8",
                    completionCount = 25,
                    passingTime = 14
                )
            ) {

            }
        }

        item {
            TestPreviewCard(
                testDescription = TestDescription(
                    title = "Test 9",
                    description = "Description for Test 9",
                    completionCount = 0,
                    passingTime = 22
                )
            ) {

            }
        }

        item {
            TestPreviewCard(
                testDescription = TestDescription(
                    title = "Test 10",
                    description = "Description for Test 10",
                    completionCount = 22,
                    passingTime = 17
                )
            ) {

            }
        }

    }
}