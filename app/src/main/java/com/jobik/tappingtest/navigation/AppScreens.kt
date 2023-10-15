package com.jobik.tappingtest.navigation

import android.util.Log
import androidx.annotation.Keep

@Keep
sealed class AppScreens(val route: String) {
    data object MainScreen : AppScreens(route = "MainScreen")
    data object TappingTestScreen : AppScreens(route = "TappingTestScreen")
    data object Statistics : AppScreens(route = "Statistics")
    data object Settings : AppScreens(route = "Settings")

    object Routes {
        val navigationBarRoutes = listOf(MainScreen, Statistics, Statistics)
        val secondaryRoutes = listOf(TappingTestScreen)

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

        fun isSecondaryRoute(route: String): Boolean {
            return secondaryRoutes.any { it.route.substringBefore("/") == route }
        }
    }
}