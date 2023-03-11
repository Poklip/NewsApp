package com.example.whatsnewintheworld.feature.bookmarks.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.whatsnewintheworld.feature.bookmarks.di.BOOKMARKS_TABLE
import com.example.whatsnewintheworld.feature.data.model.SourceRemoteModel

@Entity(tableName = BOOKMARKS_TABLE)
data class BookmarkEntity(
    @PrimaryKey
    @ColumnInfo("author")
    val author: String?,
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