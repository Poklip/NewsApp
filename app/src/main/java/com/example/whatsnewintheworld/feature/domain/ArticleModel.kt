package com.example.whatsnewintheworld.feature.domain

import com.example.whatsnewintheworld.feature.data.model.SourceRemoteModel

data class ArticleModel (
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val publishedAt: String,
    val sourceName: String
    )
