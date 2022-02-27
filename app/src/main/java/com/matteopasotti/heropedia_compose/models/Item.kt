package com.matteopasotti.heropedia_compose.models

data class Item(
    val resourceURI: String,
    val name: String,
    val type: String?,
    val role: String?,
    var image: String?
)