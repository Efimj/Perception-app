package com.jobik.tappingtest.screens.Main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jobik.tappingtest.components.TestPreviewCard.TestPreviewCard
import com.jobik.tappingtest.navigation.AppScreens
import com.jobik.tappingtest.ui.theme.CustomTheme

@Composable
fun MainScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().background(CustomTheme.Colors.mainBackground),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 40.dp)
    ) {
        item {
            TestPreviewCard(title = "Tapping test") {
                navController.navigate(AppScreens.TappingTestScreen.route)
            }
        }
        item {
            TestPreviewCard(title = "Knowledge Challenge") {

            }
        }
        item {
            TestPreviewCard(title = "QuizMaster Pro") {

            }
        }
        item {
            TestPreviewCard(title = "Brain Teaser") {

            }
        }
        item {
            TestPreviewCard(title = "Trivia Time") {

            }
        }
        item {
            TestPreviewCard(title = "Quiz Quest") {

            }
        }
        item {
            TestPreviewCard(title = "Test Your Wits") {

            }
        }
        item {
            TestPreviewCard(title = "MindMaze") {

            }
        }
        item {
            TestPreviewCard(title = "Quizzeria") {

            }
        }
        item {
            TestPreviewCard(title = "Brain Blitz") {

            }
        }
        item {
            TestPreviewCard(title = "Challenge Yourself") {

            }
        }

        // dwasd

        item {
            TestPreviewCard(title = "Tapping test") {
                navController.navigate(AppScreens.TappingTestScreen.route)
            }
        }
        item {
            TestPreviewCard(title = "Knowledge Challenge") {

            }
        }
        item {
            TestPreviewCard(title = "QuizMaster Pro") {

            }
        }
        item {
            TestPreviewCard(title = "Brain Teaser") {

            }
        }
        item {
            TestPreviewCard(title = "Trivia Time") {

            }
        }
        item {
            TestPreviewCard(title = "Quiz Quest") {

            }
        }
        item {
            TestPreviewCard(title = "Test Your Wits") {

            }
        }
        item {
            TestPreviewCard(title = "MindMaze") {

            }
        }
        item {
            TestPreviewCard(title = "Quizzeria") {

            }
        }
        item {
            TestPreviewCard(title = "Brain Blitz") {

            }
        }
        item {
            TestPreviewCard(title = "Challenge Yourself") {

            }
        }
    }
}