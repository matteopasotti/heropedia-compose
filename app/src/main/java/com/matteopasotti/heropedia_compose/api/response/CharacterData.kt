package com.matteopasotti.heropedia_compose.api.response

import com.matteopasotti.heropedia_compose.models.Character

data class CharacterData(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    var results: MutableList<Character>
)