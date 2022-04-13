package com.example.adaptivelayouts.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.adaptivelayouts.ui.favorite.FavoriteScreen
import com.example.adaptivelayouts.ui.home.HomeScreen
import com.example.adaptivelayouts.ui.search.SearchScreen

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
            FavoriteScreen()
        }
        composable(AdaptiveLayoutsDestinations.Search.route) {
            SearchScreen()
        }
    }
}