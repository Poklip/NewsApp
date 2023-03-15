package com.example.whatsnewintheworld.feature.di

import com.example.whatsnewintheworld.feature.data.ArticlesRemoteSource
import com.example.whatsnewintheworld.feature.data.ArticlesRepository
import com.example.whatsnewintheworld.feature.data.ArticlesRepositoryImpl
import com.example.whatsnewintheworld.feature.data.NewsApi
import com.example.whatsnewintheworld.feature.domain.ArticlesInteractor
import com.example.whatsnewintheworld.feature.mainscreen.MainScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val mainScreenModule = module {
    single {
        get<Retrofit>().create(NewsApi::class.java)
    }

    single<ArticlesRemoteSource> {
        ArticlesRemoteSource(api = get())
    }

    single<ArticlesRepository>{
        ArticlesRepositoryImpl(articlesRemoteSource = get())
    }

    single<ArticlesInteractor>{
        ArticlesInteractor(articlesRepository = get())
    }

    viewModel {MainScreenViewModel(interactor = get(), bookmarksInteractor = get())
    }
}