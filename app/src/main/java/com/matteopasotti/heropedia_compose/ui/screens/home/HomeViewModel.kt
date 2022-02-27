package com.matteopasotti.heropedia_compose.ui.screens.home

import androidx.lifecycle.viewModelScope
import com.matteopasotti.heropedia_compose.repositories.CharacterRepository
import com.matteopasotti.heropedia_compose.viewmodels.BaseStateViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val characterRepository: CharacterRepository) :
    BaseStateViewModel<HomeState, HomeEvents>(HomeState.Idle) {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getCharacters()
        }
    }

    private suspend fun getCharacters() {
        val items =
            characterRepository.getCharacters("-modified", offset = 0, limit = 20).data.results

        if (items != null) {
            setState(HomeState.Content(characters = items))
        }
    }
}