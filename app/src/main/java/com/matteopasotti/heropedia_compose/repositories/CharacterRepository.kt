package com.matteopasotti.heropedia_compose.repositories

import com.matteopasotti.heropedia_compose.models.Character

interface CharacterRepository {
    suspend fun getCharacters(modified: String, offset: Int, limit: Int): List<Character>
}