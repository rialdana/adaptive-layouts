package com.example.adaptivelayouts.ui.navigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.adaptivelayouts.ui.home.HomeScreen

@Composable
fun AdaptiveLayoutsNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = AdaptiveLayoutsDestinations.Home.route,
    ) {
        composable(AdaptiveLayoutsDestinations.Home.route) {
            HomeScreen()
        }
        composable(AdaptiveLayoutsDestinations.Favorites.route) {
            Text(text = "Favorites")
        }
        composable(AdaptiveLayoutsDestinations.Search.route) {
            Text(text = "Search")
        }
    }
}