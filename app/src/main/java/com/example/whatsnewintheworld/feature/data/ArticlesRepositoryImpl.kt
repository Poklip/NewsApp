package com.example.whatsnewintheworld.feature.data

import com.example.whatsnewintheworld.feature.domain.ArticleModel


class ArticlesRepositoryImpl(private val articlesRemoteSource: ArticlesRemoteSource) : ArticlesRepository {
    override suspend fun getArticles(): List<ArticleModel> {
        return articlesRemoteSource.getArticles().articleList.asSequence().map {
            it.toDomain()
        }.map {
            it.copy(publishedAt = "Published at " + it.publishedAt.replace("T", "\t").substringBefore('Z'))
        }.toList()
    }
}