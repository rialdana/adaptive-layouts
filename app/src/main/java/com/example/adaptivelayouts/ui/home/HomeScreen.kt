package com.example.adaptivelayouts.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.GridItemSpan
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.adaptivelayouts.ui.theme.AdaptiveLayoutsTheme
import com.example.adaptivelayouts.ui.theme.LargePadding
import com.example.adaptivelayouts.ui.theme.MediumPadding
import com.example.adaptivelayouts.ui.theme.SmallPadding
import com.example.adaptivelayouts.ui.theme.XLargePadding
import com.example.adaptivelayouts.ui.theme.XXLargePadding
import com.example.adaptivelayouts.ui.utils.LocalWindowsSize
import com.example.adaptivelayouts.ui.utils.WindowSize

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    val currentWindowSize = LocalWindowsSize.current
    val horizontalPadding = when (currentWindowSize) {
        WindowSize.Compact -> MediumPadding
        WindowSize.Medium -> LargePadding
        WindowSize.Expanded -> XLargePadding
    }

    val items = buildList {
        for (i in 1..20) {
            add(i)
        }
    }

    if (currentWindowSize == WindowSize.Expanded) {
        val header = items.first()
        val gridItems = items.filter { it != header }
        val spanCount = 2

        LazyVerticalGrid(
            cells = GridCells.Fixed(spanCount),
            contentPadding = PaddingValues(horizontal = horizontalPadding),
        ) {
            item(
                span = { GridItemSpan(spanCount) }
            ) {
                HomeItemCard(position = header)
            }

            items(gridItems) { position ->
                HomeItemCard(position = position)
            }
        }
    } else {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = horizontalPadding),
        ) {
            items(items) { position ->
                HomeItemCard(position = position)
            }
        }
    }
}

@Composable
private fun HomeItemCard(position: Int) {
    val currentWindowSize = LocalWindowsSize.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(SmallPadding)
            .clickable { },
    ) {
        Column(
            modifier = Modifier.padding(MediumPadding),
        ) {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = null,
                modifier = Modifier
                    .aspectRatio(ratio = 1.77f)
                    .padding(XXLargePadding),
                tint = MaterialTheme.colors.onBackground,
            )
            Spacer(modifier = Modifier.height(SmallPadding))
            Text(
                text = "Item $position",
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
            )
            if (currentWindowSize != WindowSize.Compact) {
                Spacer(modifier = Modifier.height(SmallPadding))

                Text(
                    text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "Home - Compact")
@Composable
private fun HomeScreenCompactPreview() {
    AdaptiveLayoutsTheme {
        HomeScreen()
    }
}

@Preview(showBackground = true, widthDp = 800, name = "Home - Medium")
@Composable
private fun HomeScreenMediumPreview() {
    CompositionLocalProvider(LocalWindowsSize provides WindowSize.Medium) {
        AdaptiveLayoutsTheme {
            HomeScreen()
        }
    }
}

@Preview(showBackground = true, widthDp = 1000, heightDp = 1300, name = "Home - Expanded")
@Composable
private fun HomeScreenExpandedPreview() {
    CompositionLocalProvider(LocalWindowsSize provides WindowSize.Expanded) {
        AdaptiveLayoutsTheme {
            HomeScreen()
        }
    }
}