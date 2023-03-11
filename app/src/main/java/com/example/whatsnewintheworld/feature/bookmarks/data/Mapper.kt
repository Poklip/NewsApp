package com.example.whatsnewintheworld.feature.bookmarks.data

import com.example.whatsnewintheworld.feature.domain.ArticleModel
import com.example.whatsnewintheworld.feature.bookmarks.data.local.model.BookmarkEntity

fun BookmarkEntity.toDomain() = ArticleModel(
    author = author ?: "Satan",
    title = title,
    description = description ?: "Nothing happened.",
    url = url,
    publishedAt = publishedAt,
    source = source,
    urlToImage = urlToImage
)

fun ArticleModel.toEntity() = BookmarkEntity(
    author = author,
    title = title,
    description = description,
    url = url,
    publishedAt = publishedAt,
    source = source,
    urlToImage = urlToImage
)