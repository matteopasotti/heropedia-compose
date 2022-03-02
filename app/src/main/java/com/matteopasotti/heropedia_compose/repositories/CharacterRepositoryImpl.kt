package com.matteopasotti.heropedia_compose.repositories

import com.matteopasotti.heropedia_compose.api.MarvelApi
import com.matteopasotti.heropedia_compose.models.Character

class CharacterRepositoryImpl(private val marvelApi: MarvelApi): CharacterRepository {
    override suspend fun getCharacters(
        modified: String,
        offset: Int,
        limit: Int
    ): List<Character> {
        return marvelApi.getCharacters(modified, offset, limit).data.results
    }
}