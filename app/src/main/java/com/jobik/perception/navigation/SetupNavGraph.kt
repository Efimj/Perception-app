package com.jobik.perception.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jobik.perception.screens.Main.MainScreen
import com.jobik.perception.screens.Settings.SettingsScreen
import com.jobik.perception.screens.Statistics.StatisticsScreen
import com.jobik.perception.screens.TappingTest.TappingTestScreen
import com.jobik.perception.screens.TestPreview.TestPreview

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(
            route = AppScreens.MainScreen.route,
            enterTransition = { slideInHorizontally(initialOffsetX = { -it }, animationSpec = tween(200)) },
            exitTransition = { slideOutHorizontally(targetOffsetX = { -it }, animationSpec = tween(200)) }
        ) {
            MainScreen(navController)
        }

        composable(
            route = AppScreens.Statistics.route,
            enterTransition = {
                when (initialState.destination.route) {
                    AppScreens.Settings.route -> slideInHorizontally(
                        initialOffsetX = { -it },
                        animationSpec = tween(200)
                    )

                    AppScreens.MainScreen.route -> slideInHorizontally(
                        initialOffsetX = { it },
                        animationSpec = tween(200)
                    )

                    else -> slideInHorizontally(initialOffsetX = { -it }, animationSpec = tween(200))
                }
            },
            exitTransition = {
                when (targetState.destination.route) {
                    AppScreens.MainScreen.route -> slideOutHorizontally(
                        targetOffsetX = { it },
                        animationSpec = tween(200)
                    )

                    AppScreens.Settings.route -> slideOutHorizontally(
                        targetOffsetX = { -it },
                        animationSpec = tween(200)
                    )

                    else -> slideOutHorizontally(targetOffsetX = { -it }, animationSpec = tween(200))
                }
            }
        ) {
            StatisticsScreen(navController)
        }

        composable(
            route = AppScreens.Settings.route,
            enterTransition = { slideInHorizontally(initialOffsetX = { it }, animationSpec = tween(200)) },
            exitTransition = { slideOutHorizontally(targetOffsetX = { it }, animationSpec = tween(200)) }
        ) {
            SettingsScreen(navController)
        }

        composable(
            route = AppScreens.TestPreview.route,
            //enterTransition = { slideInHorizontally(initialOffsetX = { it }, animationSpec = tween(200)) },
            //exitTransition = { slideOutHorizontally(targetOffsetX = { it }, animationSpec = tween(200)) }
        ) {
            TestPreview(navController)
        }

        composable(
            route = AppScreens.TappingTestScreen.route,
            //enterTransition = { slideInHorizontally(initialOffsetX = { it }, animationSpec = tween(200)) },
            //exitTransition = { slideOutHorizontally(targetOffsetX = { it }, animationSpec = tween(200)) }
        ) {
            TappingTestScreen(navController)
        }
    }
}
