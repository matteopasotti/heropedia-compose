package com.matteopasotti.heropedia_compose.ui.screens.home

import androidx.paging.PagingData
import com.matteopasotti.heropedia_compose.models.Character
import kotlinx.coroutines.flow.Flow

sealed class HomeState {
    object Idle : HomeState()
    class Error : HomeState()

    data class Content(
        val characters: Flow<PagingData<Character>>
    ) : HomeState()
}