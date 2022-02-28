package com.matteopasotti.heropedia_compose.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.matteopasotti.heropedia_compose.R

@Composable
fun MarvelCardCharacter(
    imageUrl: String,
    title: String,
    onItemClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(10.dp)
            .clickable { onItemClicked() },
        contentAlignment = Alignment.Center
    ) {
        MarvelImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .clip(RoundedCornerShape(20.dp)),
            imageUrl = imageUrl,
            contentScale = ContentScale.Crop,
            placeholder = R.drawable.ironman
        )
    }
}

@Preview
@Composable
fun ShowMarvelCardCharacterPreview() {
    MarvelCardCharacter(imageUrl = "", title = "Iron Man") {}
}