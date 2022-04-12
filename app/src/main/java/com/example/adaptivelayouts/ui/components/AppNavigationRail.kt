package com.example.adaptivelayouts.ui.components

import androidx.compose.material.NavigationRail
import androidx.compose.material.NavigationRailItem
import androidx.compose.runtime.Composable
import com.example.adaptivelayouts.ui.navigation.AdaptiveLayoutsDestinations

@Composable
fun AppNavigationRail(
    currentRoute: String,
    navigateToHome: () -> Unit,
    navigateToFavorites: () -> Unit,
    navigateToSearch: () -> Unit,
) {
    val homeDestination = AdaptiveLayoutsDestinations.Home
    val searchDestination = AdaptiveLayoutsDestinations.Search
    val favoritesDestination = AdaptiveLayoutsDestinations.Favorites

    NavigationRail {
        NavigationRailItem(
            selected = currentRoute == homeDestination.route,
            onClick = navigateToHome,
            icon = { NavigationIcon(destination = homeDestination) }
        )

        NavigationRailItem(
            selected = currentRoute == searchDestination.route,
            onClick = navigateToSearch,
            icon = { NavigationIcon(destination = searchDestination) }
        )

        NavigationRailItem(
            selected = currentRoute == favoritesDestination.route,
            onClick = navigateToFavorites,
            icon = { NavigationIcon(destination = favoritesDestination) }
        )
    }
}