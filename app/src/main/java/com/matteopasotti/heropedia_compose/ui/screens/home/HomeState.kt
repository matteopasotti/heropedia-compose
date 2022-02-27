package com.matteopasotti.heropedia_compose.ui.screens.home

import com.matteopasotti.heropedia_compose.models.Character

sealed class HomeState {
    object Idle : HomeState()
    class Error : HomeState()

    data class Content(
        val characters: List<Character>
    ) : HomeState()
}