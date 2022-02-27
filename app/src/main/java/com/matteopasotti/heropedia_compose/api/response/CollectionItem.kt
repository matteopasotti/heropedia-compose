package com.matteopasotti.heropedia_compose.api.response

import com.matteopasotti.heropedia_compose.models.Item

data class CollectionItem(
    val available: Int,
    val collectionURI: String?,
    val items: MutableList<Item>?,
    val returned: Int
)