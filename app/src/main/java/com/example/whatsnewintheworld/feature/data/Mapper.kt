package com.example.whatsnewintheworld.feature.data

import com.example.whatsnewintheworld.feature.data.model.ArticleRemoteModel
import com.example.whatsnewintheworld.feature.data.model.SourceRemoteModel
import com.example.whatsnewintheworld.feature.domain.ArticleModel

fun ArticleRemoteModel.toDomain() = ArticleModel(
        author = author ?: "Satan",
        title = title,
        description = description ?: "Nothing happened.",
        url = url,
        publishedAt = publishedAt,
        urlToImage = urlToImage,
        source = source.sourceName
)

