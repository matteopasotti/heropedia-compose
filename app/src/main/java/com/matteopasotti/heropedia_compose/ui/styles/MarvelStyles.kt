package com.matteopasotti.heropedia_compose.ui.styles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.matteopasotti.heropedia_compose.ui.theme.ProductSans

internal fun getLabelStyle() =
    TextStyle(
        fontFamily = ProductSans,
        fontWeight = FontWeight.ExtraBold,
        color = Color.White
    )