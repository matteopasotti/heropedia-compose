package com.matteopasotti.heropedia_compose.di

import com.matteopasotti.heropedia_compose.repositories.CharacterRepository
import com.matteopasotti.heropedia_compose.repositories.CharacterRepositoryImpl
import com.matteopasotti.heropedia_compose.ui.screens.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<CharacterRepository> { CharacterRepositoryImpl(marvelApi = get()) }

    viewModel { HomeViewModel(get()) }
}