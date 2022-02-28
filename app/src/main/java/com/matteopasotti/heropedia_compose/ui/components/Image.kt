package com.matteopasotti.heropedia_compose.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.compose.rememberImagePainter
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth


@Composable
fun MarvelImage(
    modifier: Modifier,
    imageUrl: String,
    contentScale: ContentScale,
    contentDescription: String? = null,
    @DrawableRes placeholder: Int? = null,
    @DrawableRes errorImage: Int? = null
) {
    Image(
        painter = rememberImagePainter(
            data = imageUrl,
            builder = {
                crossfade(true)
                errorImage?.let { error(it) }
                placeholder?.let { placeholder(it) }

            }),
        modifier = modifier.fillMaxWidth(),
        contentDescription = contentDescription,
        contentScale = contentScale
    )
}