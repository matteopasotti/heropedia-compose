package com.matteopasotti.heropedia_compose.models

import androidx.room.Embedded
import androidx.room.Entity
import com.matteopasotti.heropedia_compose.api.response.CollectionItem
import com.matteopasotti.heropedia_compose.api.response.ItemUrl
import com.matteopasotti.heropedia_compose.api.response.Thumbnail

@Entity(primaryKeys = ["id"])
data class Character(val id: Int, val name: String,
                     val description: String,
                     val modified: String,
                     @Embedded(prefix = "thumbnail_")
                     val thumbnail: Thumbnail,
                     val resourceURI: String?,
                     @Embedded(prefix = "comics_")
                     val comics: CollectionItem,
                     @Embedded(prefix = "series_")
                     val series: CollectionItem,
                     @Embedded(prefix = "stories_")
                     val stories: CollectionItem,
                     @Embedded(prefix = "events_")
                     val events: CollectionItem,
                     val urls: MutableList<ItemUrl>,
                     var page : Int)