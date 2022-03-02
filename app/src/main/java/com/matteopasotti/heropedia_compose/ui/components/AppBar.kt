package com.matteopasotti.heropedia_compose.ui.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.matteopasotti.heropedia_compose.ui.theme.MarvelBlack85
import com.matteopasotti.heropedia_compose.ui.theme.MarvelLightBlue

@Composable
fun HomeAppBar(title: String, isDarkTheme: Boolean, openSearch: () -> Unit) {
    TopAppBar(
        title = { Text(text = title) },
        backgroundColor = if (isDarkTheme) MarvelBlack85 else MarvelLightBlue,
        contentColor = if(isDarkTheme) Color.White else Color.Black,
        actions = {
            IconButton(onClick = openSearch) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search",
                    tint = if (isDarkTheme) Color.White else Color.Black
                )
            }
        }
    )
}

@Preview
@Composable
fun ShowHomeAppBarPreviewLight() {
    HomeAppBar(title = "Heropedia", isDarkTheme = false) {}
}

@Preview
@Composable
fun ShowHomeAppBarPreviewDark() {
    HomeAppBar(title = "Heropedia", isDarkTheme = true) {}
}