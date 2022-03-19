package com.matteopasotti.heropedia_compose.di

import androidx.room.Room
import com.matteopasotti.heropedia_compose.db.AppDatabase
import org.koin.dsl.module

val dbModule = module {

    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "ComicCatalogDB.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().characterDao() }

}