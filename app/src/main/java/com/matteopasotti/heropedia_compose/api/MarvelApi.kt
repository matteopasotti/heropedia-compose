package com.matteopasotti.heropedia_compose.api

import androidx.annotation.Nullable
import com.matteopasotti.heropedia_compose.api.response.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApi {
    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("orderBy") modified: String,
        @Nullable @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): CharacterResponse
}