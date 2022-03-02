package com.matteopasotti.heropedia_compose.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.matteopasotti.heropedia_compose.R
import com.matteopasotti.heropedia_compose.ui.styles.getLabelStyle

@Composable
fun MarvelCardCharacter(
    imageUrl: String,
    onItemClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(5.dp)
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

@Composable
fun MarvelCardCharacterWithTitle(
    imageUrl: String,
    title: String,
    onItemClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClicked() },
        contentAlignment = Alignment.Center
    ) {
        ConstraintLayout(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            val (image, titleLabel) = createRefs()

            MarvelImage(
                modifier = Modifier
                    .constrainAs(image) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                    }
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(20.dp)),
                imageUrl = imageUrl,
                contentScale = ContentScale.Crop,
                placeholder = R.drawable.ironman
            )

            Text(modifier = Modifier
                .constrainAs(titleLabel) {
                    bottom.linkTo(image.bottom)
                    start.linkTo(image.start)
                }
                .wrapContentWidth()
                .wrapContentHeight()
                .padding(start = 16.dp, bottom = 10.dp),
                text = title,
                style = getLabelStyle(),
                fontSize = 16.sp,
                maxLines = 1)

        }


    }
}


@Preview
@Composable
fun ShowMarvelCardCharacterPreview() {
    MarvelCardCharacter(imageUrl = "") {}
}

@Preview
@Composable
fun ShowMarvelCardCharacterWithTitlePreview() {
    MarvelCardCharacterWithTitle(imageUrl = "", title = "Iron Man") {}
}