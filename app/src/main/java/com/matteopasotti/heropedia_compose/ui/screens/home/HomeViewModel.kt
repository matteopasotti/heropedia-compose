package com.matteopasotti.heropedia_compose.ui.screens.home

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.matteopasotti.heropedia_compose.models.Character
import com.matteopasotti.heropedia_compose.repositories.CharacterRepository
import com.matteopasotti.heropedia_compose.viewmodels.BaseStateViewModel
import kotlinx.coroutines.flow.Flow

class HomeViewModel(
    private val characterRepository: CharacterRepository
) : BaseStateViewModel<HomeState, HomeEvents>(HomeState.Idle) {

    val characters: Flow<PagingData<Character>> = Pager(PagingConfig(pageSize = 20)) {
        CharacterSource(characterRepository)
    }.flow

}