package com.matteopasotti.heropedia_compose

import android.app.Application
import com.matteopasotti.heropedia_compose.di.appModule
import com.matteopasotti.heropedia_compose.di.dbModule
import com.matteopasotti.heropedia_compose.di.netModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.fileProperties

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@MyApplication)
            modules(appModule, netModule, dbModule)
            fileProperties()
        }
    }
}