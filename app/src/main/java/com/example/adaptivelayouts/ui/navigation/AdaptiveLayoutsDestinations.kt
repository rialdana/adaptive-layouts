package com.example.adaptivelayouts.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import com.example.adaptivelayouts.R


/**
 * Destinations used in the app
 */
sealed class AdaptiveLayoutsDestinations(val route: String, val icon: ImageVector, val name: Int) {
    object Home : AdaptiveLayoutsDestinations(
        route = "home",
        icon = Icons.Filled.Home,
        name = R.string.destination_home,
    )

    object Search : AdaptiveLayoutsDestinations(
        route = "search",
        icon = Icons.Filled.Search,
        name = R.string.destination_search,
    )

    object Favorites : AdaptiveLayoutsDestinations(
        route = "favorites",
        icon = Icons.Filled.Favorite,
        name = R.string.destination_favorites,
    )
}

/**
 * Navigation actions in the app
 */

class AdaptiveLayoutsNavigationActions(navController: NavHostController) {
    val navigateToHome: () -> Unit = {
        navController.navigate(AdaptiveLayoutsDestinations.Home.route) {
            navigateAndClearStack(navController = navController)
        }
    }

    val navigateToSearch: () -> Unit = {
        navController.navigate(AdaptiveLayoutsDestinations.Search.route) {
            navigateAndClearStack(navController = navController)
        }
    }

    val navigateToFavorites: () -> Unit = {
        navController.navigate(AdaptiveLayoutsDestinations.Favorites.route) {
            navigateAndClearStack(navController = navController)
        }
    }

    private fun NavOptionsBuilder.navigateAndClearStack(navController: NavHostController) {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
        }
        // Avoid multiple copies of the same destination when
        // reselecting the same item
        launchSingleTop = true
        // Restore state when reselecting a previously selected item
        restoreState = true
    }
}