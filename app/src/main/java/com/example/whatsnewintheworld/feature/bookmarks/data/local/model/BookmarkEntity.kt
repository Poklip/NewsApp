package com.example.whatsnewintheworld.feature.bookmarks.data.local.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.whatsnewintheworld.feature.bookmarks.di.BOOKMARKS_TABLE

@Entity(tableName = BOOKMARKS_TABLE)
data class BookmarkEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo("author")
    val author: String,
    @ColumnInfo("title")
    val title: String,
    @ColumnInfo("description")
    val description: String?,
    @ColumnInfo("url")
    val url: String,
    @ColumnInfo("publishedAt")
    val publishedAt: String,
    @ColumnInfo("source")
    val source: String,
    @ColumnInfo("urlToImage")
    val urlToImage: String?,
)