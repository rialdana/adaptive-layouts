package com.example.adaptivelayouts.ui.navigation

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.adaptivelayouts.R
import com.example.adaptivelayouts.ui.components.AppBottomNav
import com.example.adaptivelayouts.ui.components.AppNavigationRail
import com.example.adaptivelayouts.ui.theme.AdaptiveLayoutsTheme
import com.example.adaptivelayouts.ui.utils.LocalWindowsSize
import com.example.adaptivelayouts.ui.utils.WindowSize

@Composable
fun AdaptiveLayoutsApp() {
    val navController = rememberNavController()
    val navigationActions = remember(navController) {
        AdaptiveLayoutsNavigationActions(navController = navController)
    }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute =
        navBackStackEntry?.destination?.route ?: AdaptiveLayoutsDestinations.Home.route
    val currentWindowSize = LocalWindowsSize.current

    AdaptiveLayoutsTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.app_name))
                    }
                )
            },
            bottomBar = {
                if (currentWindowSize == WindowSize.Compact) {
                    AppBottomNav(
                        currentRoute = currentRoute,
                        navigateToHome = navigationActions.navigateToHome,
                        navigateToFavorites = navigationActions.navigateToFavorites,
                        navigateToSearch = navigationActions.navigateToSearch,
                    )
                }
            }
        ) {
            Row {
                if (currentWindowSize != WindowSize.Compact) {
                    AppNavigationRail(
                        currentRoute = currentRoute,
                        navigateToHome = navigationActions.navigateToHome,
                        navigateToFavorites = navigationActions.navigateToFavorites,
                        navigateToSearch = navigationActions.navigateToSearch,
                    )
                }

                AdaptiveLayoutsNavGraph(
                    navController = navController,
                )
            }
        }
    }
}
