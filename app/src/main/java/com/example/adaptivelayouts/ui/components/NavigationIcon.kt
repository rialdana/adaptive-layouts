package com.example.adaptivelayouts.ui.components

import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.adaptivelayouts.ui.navigation.AdaptiveLayoutsDestinations

@Composable
fun NavigationIcon(
    destination: AdaptiveLayoutsDestinations,
) {
    Icon(
        imageVector = destination.icon,
        contentDescription = stringResource(id = destination.name),
    )
}