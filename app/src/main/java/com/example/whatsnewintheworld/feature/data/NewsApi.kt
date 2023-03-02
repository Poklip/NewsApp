package com.example.whatsnewintheworld.feature.data

import com.example.whatsnewintheworld.di.API_KEY
import com.example.whatsnewintheworld.feature.data.model.ArticlesRemoteModel
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("v2/top-headlines")
    suspend fun getArticles(
        @Query("country") country: String = "ru",
        @Query("apiKey") apiKey: String = API_KEY
    ): ArticlesRemoteModel
}