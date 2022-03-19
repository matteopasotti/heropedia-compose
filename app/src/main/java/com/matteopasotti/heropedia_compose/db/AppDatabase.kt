package com.matteopasotti.heropedia_compose.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.matteopasotti.heropedia_compose.db.daos.CharacterDao
import com.matteopasotti.heropedia_compose.models.Character


@Database(entities = [(Character::class)], version = 1)
@TypeConverters(RoomConverters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun characterDao() : CharacterDao
}