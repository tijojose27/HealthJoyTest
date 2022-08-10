package com.example.healthjoy.Services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFiitInstance  {
    val baseURL = "https://api.giphy.com/v1/gifs/"

    val api: GliphyAPI by lazy {
        Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GliphyAPI::class.java)
    }
}