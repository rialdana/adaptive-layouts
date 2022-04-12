package com.example.adaptivelayouts.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.runtime.Composable
import com.example.adaptivelayouts.ui.navigation.AdaptiveLayoutsDestinations

@Composable
fun AppBottomNav(
    currentRoute: String,
    navigateToHome: () -> Unit,
    navigateToFavorites: () -> Unit,
    navigateToSearch: () -> Unit,
) {

    val homeDestination = AdaptiveLayoutsDestinations.Home
    val searchDestination = AdaptiveLayoutsDestinations.Search
    val favoritesDestination = AdaptiveLayoutsDestinations.Favorites

    BottomNavigation {
        BottomNavigationItem(
            selected = currentRoute == homeDestination.route,
            onClick = navigateToHome,
            icon = { NavigationIcon(destination = homeDestination) }
        )

        BottomNavigationItem(
            selected = currentRoute == searchDestination.route,
            onClick = navigateToSearch,
            icon = { NavigationIcon(destination = searchDestination) }
        )

        BottomNavigationItem(
            selected = currentRoute == favoritesDestination.route,
            onClick = navigateToFavorites,
            icon = { NavigationIcon(destination = favoritesDestination) }
        )
    }
}
