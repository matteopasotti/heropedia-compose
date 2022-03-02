package com.matteopasotti.heropedia_compose.ui.screens.home

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.matteopasotti.heropedia_compose.models.Character
import com.matteopasotti.heropedia_compose.repositories.CharacterRepository
import java.lang.Exception

class CharacterSource(private val characterRepository: CharacterRepository) :
    PagingSource<Int, Character>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        val nextPage = params.key ?: 0
        val nextCharacters = characterRepository.getCharacters("-modified", nextPage, 20)

        return if(nextCharacters.isEmpty()) {
            LoadResult.Error(
                Exception("Failed to load characters")
            )
        } else {
            LoadResult.Page(
                data = nextCharacters,
                prevKey = if(nextPage == 0) null else nextPage - 1,
                nextKey = nextPage.plus(20)
            )
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return null
    }
}