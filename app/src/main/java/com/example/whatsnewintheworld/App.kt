package com.example.whatsnewintheworld

import android.app.Application
import com.example.whatsnewintheworld.di.databaseModule
import com.example.whatsnewintheworld.di.networkModule
import com.example.whatsnewintheworld.feature.bookmarks.di.bookmarksModule
import com.example.whatsnewintheworld.feature.di.mainScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@App)
            // Load modules
            modules(networkModule, mainScreenModule, bookmarksModule, databaseModule)
        }
    }
}