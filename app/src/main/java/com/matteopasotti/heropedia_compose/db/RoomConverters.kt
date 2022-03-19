package com.matteopasotti.heropedia_compose.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.matteopasotti.heropedia_compose.api.response.CollectionItem
import com.matteopasotti.heropedia_compose.api.response.Thumbnail
import java.util.*

class RoomConverters {

    var gson = Gson()

    @TypeConverter
    fun stringToThumbnail(data: String?): Thumbnail? {
        if (data == null) {
            return null
        }

        val obj = object : TypeToken<Thumbnail>() {}.type

        return gson.fromJson(data, obj)
    }

    @TypeConverter
    fun thumbnailToString(someObject: Thumbnail): String {
        return gson.toJson(someObject)
    }

    @TypeConverter
    fun stringToCollectionItem(data: String?): CollectionItem? {

        if (data == null) {
            return null
        }

        val obj = object : TypeToken<CollectionItem>() {}.type

        return gson.fromJson(data, obj)
    }

    @TypeConverter
    fun collectionItemToString(someObject: CollectionItem?): String? {
        if (someObject == null) {
            return null
        }
        return gson.toJson(someObject)
    }

    @TypeConverter
    fun stringToListThumbnail(data: String?): MutableList<Thumbnail> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<MutableList<Thumbnail>>() {

        }.type

        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun thumbnailListToString(someObjects: MutableList<Thumbnail>?): String? {
        if (someObjects == null) {
            return null
        }
        return gson.toJson(someObjects)
    }
}