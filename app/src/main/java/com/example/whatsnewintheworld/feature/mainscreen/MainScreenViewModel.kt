package com.example.whatsnewintheworld.feature.mainscreen

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.whatsnewintheworld.MainActivity
import com.example.whatsnewintheworld.R
import com.example.whatsnewintheworld.base.BaseViewModel
import com.example.whatsnewintheworld.base.MyEvent
import com.example.whatsnewintheworld.feature.article.ui.ArticleFragment
import com.example.whatsnewintheworld.feature.bookmarks.domain.BookmarksInteractor
import com.example.whatsnewintheworld.feature.domain.ArticlesInteractor
import kotlinx.coroutines.launch

class MainScreenViewModel(private val interactor: ArticlesInteractor, private val bookmarksInteractor: BookmarksInteractor) : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.LoadArticles)
    }

    override fun initialViewState() = ViewState(articles = emptyList(), articlesShown = emptyList(), isSearchEnabled = false)

    override fun reduce(event: MyEvent, previousState: ViewState): ViewState? {
        when (event) {
            is DataEvent.LoadArticles -> {
                viewModelScope.launch {
                    interactor.getArticles().fold(
                        onError = {
                            Log.e("ERROR", it.localizedMessage)
                        },
                        onSuccess = {
                            processDataEvent(DataEvent.OnLoadArticlesSucceed(it))
                        }
                    )
                }
                return null
            }

            is DataEvent.OnLoadArticlesSucceed -> {
                return previousState.copy(articles = event.articles, articlesShown = event.articles)
            }

            is UiEvent.OnArticleClicked -> {
                viewModelScope.launch {
                    MainScreenFragment().parentFragmentManager.beginTransaction().replace(R.id.container, ArticleFragment()).commit()
                    //bookmarksInteractor.create(previousState.articlesShown[event.index])
                }
                return null
            }

            is UiEvent.OnSearchButtonClicked -> {
                return previousState.copy(
                    articlesShown = if (previousState.isSearchEnabled) previousState.articles else previousState.articlesShown,
                    isSearchEnabled = !previousState.isSearchEnabled)
            }

            is UiEvent.OnSearchEdited -> {
                return previousState.copy(articlesShown = previousState.articles.filter {
                    it.title.contains(event.keyText) })
            }

            else -> return null
        }
    }
}