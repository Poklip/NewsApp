package com.example.whatsnewintheworld.feature.mainscreen

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.whatsnewintheworld.base.BaseViewModel
import com.example.whatsnewintheworld.base.MyEvent
import com.example.whatsnewintheworld.feature.domain.ArticlesInteractor
import kotlinx.coroutines.launch

class MainScreenViewModel(private val interactor: ArticlesInteractor) : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.LoadArticles)
    }

    override fun initialViewState() = ViewState(articles = emptyList())

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
                return previousState.copy(articles = event.articles)
            }
            else -> return null
        }
    }
}