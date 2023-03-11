package com.example.whatsnewintheworld

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.whatsnewintheworld.feature.bookmarks.data.local.BookmarkDao
import com.example.whatsnewintheworld.feature.bookmarks.data.local.model.BookmarkEntity

@Database(entities = [BookmarkEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun bookmarksDao(): BookmarkDao
}