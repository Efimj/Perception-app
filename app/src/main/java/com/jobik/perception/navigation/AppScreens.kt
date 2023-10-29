package com.jobik.perception.navigation

import androidx.annotation.Keep

@Keep
const val ArgumentTestName = "testName"

@Keep
sealed class AppScreens(val route: String) {
    data object MainScreen : AppScreens(route = "MainScreen")
    data object TestPreview : AppScreens(route = "TestPreview/{$ArgumentTestName}") {
        fun testId(testName: String): String {
            return this.route.replace(oldValue = "{$ArgumentTestName}", newValue = testName)
        }
    }

    data object TappingTestScreen : AppScreens(route = "TappingTestScreen")
    data object Statistics : AppScreens(route = "Statistics")
    data object Settings : AppScreens(route = "Settings")

    object Routes {
        val navigationBarRoutes = listOf(MainScreen, Statistics, Settings)
        val topBarRoutes: List<AppScreens> = emptyList()

        /**
         * @routeName1 first route
         * @routeName2 second route
         *
         * @return position difference between two routes or null if no exist route
         */
        fun navigationBarRoutesIndexDifference(routeName1: String, routeName2: String): Int? {
            runCatching {
                val route1 = navigationBarRoutes.first { it.route == routeName1 }
                val route2 = navigationBarRoutes.first { it.route == routeName2 }
                val indexOfRoute1 = navigationBarRoutes.indexOf(route1)
                val indexOfRoute2 = navigationBarRoutes.indexOf(route2)
                return indexOfRoute1 - indexOfRoute2
            }
            return null
        }

        fun isNavigationBarRoute(route: String): Boolean {
            return navigationBarRoutes.any { it.route.substringBefore("/") == route }
        }

        fun isTopBarRoute(route: String): Boolean {
            return topBarRoutes.any { it.route.substringBefore("/") == route }
        }
    }
}