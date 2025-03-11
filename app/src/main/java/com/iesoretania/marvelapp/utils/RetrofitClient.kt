package com.iesoretania.marvelapp.utils

import com.iesoretania.marvelapp.api.MarvelAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://gateway.marvel.com/"

    val instance: MarvelAPI by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MarvelAPI::class.java)
    }
}