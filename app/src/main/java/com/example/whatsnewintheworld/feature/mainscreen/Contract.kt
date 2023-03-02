package com.example.whatsnewintheworld.feature.mainscreen

import com.example.whatsnewintheworld.base.MyEvent
import com.example.whatsnewintheworld.feature.domain.ArticleModel

data class ViewState(
    val articles: List<ArticleModel>
)

sealed class DataEvent : MyEvent {
    object LoadArticles: DataEvent()
    data class OnLoadArticlesSucceed(val articles: List<ArticleModel>) : DataEvent()
}
