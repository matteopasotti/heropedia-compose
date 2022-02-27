package com.matteopasotti.heropedia_compose.models

import com.matteopasotti.heropedia_compose.api.response.CollectionItem
import com.matteopasotti.heropedia_compose.api.response.ItemUrl
import com.matteopasotti.heropedia_compose.api.response.Thumbnail

data class Character(val id: Int, val name: String,
                     val description: String,
                     val modified: String,
                     val thumbnail: Thumbnail,
                     val resourceURI: String?,
                     val comics: CollectionItem,
                     val series: CollectionItem,
                     val stories: CollectionItem,
                     val events: CollectionItem,
                     val urls: MutableList<ItemUrl>,
                     var page : Int)