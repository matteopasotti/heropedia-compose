package com.matteopasotti.heropedia_compose.repositories

import com.matteopasotti.heropedia_compose.api.response.CharacterResponse

interface CharacterRepository {
    suspend fun getCharacters(modified: String, offset: Int, limit: Int): CharacterResponse
}