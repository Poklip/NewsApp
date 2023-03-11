package com.example.whatsnewintheworld.feature.bookmarks.data.local

import com.example.whatsnewintheworld.feature.domain.ArticleModel

interface BookmarksRepository {
    suspend fun create(model: ArticleModel)

    suspend fun read(): List<ArticleModel>

    suspend fun update(model: ArticleModel)

    suspend fun delete(model: ArticleModel)
}