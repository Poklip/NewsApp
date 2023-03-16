package com.example.whatsnewintheworld.feature.mainscreen

import com.example.whatsnewintheworld.base.MyEvent
import com.example.whatsnewintheworld.feature.domain.ArticleModel

data class ViewState(
    val isSearchEnabled: Boolean,
    val articlesShown: List<ArticleModel>,
    val articles: List<ArticleModel>
)

sealed class UiEvent : MyEvent {
    data class OnArticleClicked(val index: Int) : UiEvent()
    object OnSearchButtonClicked : UiEvent()
    data class OnSearchEdited(val keyText: String) : UiEvent()
}

sealed class DataEvent : MyEvent {
    object LoadArticles: DataEvent()
    data class OnLoadArticlesSucceed(val articles: List<ArticleModel>) : DataEvent()
}
