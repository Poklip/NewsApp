package com.example.whatsnewintheworld.feature.bookmarks.domain

import com.example.whatsnewintheworld.feature.bookmarks.data.local.BookmarksRepository
import com.example.whatsnewintheworld.feature.bookmarks.data.toDomain
import com.example.whatsnewintheworld.feature.bookmarks.data.toEntity
import com.example.whatsnewintheworld.feature.domain.ArticleModel

class BookmarksInteractor(private val bookmarksRepository: BookmarksRepository) {
    suspend fun create(model: ArticleModel) {
        bookmarksRepository.create(model)
    }

    suspend fun read(): List<ArticleModel> {
        return bookmarksRepository.read()
    }

    suspend fun update(model: ArticleModel) {
        bookmarksRepository.update(model)
    }

    suspend fun delete(model: ArticleModel) {
        bookmarksRepository.delete(model)
    }
}