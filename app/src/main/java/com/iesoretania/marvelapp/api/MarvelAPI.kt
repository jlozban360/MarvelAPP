package com.iesoretania.marvelapp.api

import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelAPI {
    @GET("v1/public/characters")
    suspend fun getCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): MarvelResponse

    @GET("v1/public/characters")
    suspend fun searchCharacters(
        @Query("ts") ts: String,
        @Query("apikey") apikey: String,
        @Query("hash") hash: String,
        @Query("limit") limit: Int,
        @Query("nameStartsWith") nameStartsWith: String
    ): MarvelResponse
}