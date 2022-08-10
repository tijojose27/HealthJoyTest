package com.example.healthjoy.Services

import com.example.healthjoy.Model.GliphyResponseModel
import com.example.healthjoy.Util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GliphyAPI {

    @GET("search")
    suspend fun getSearchGliphys(@Query("api_key") apiKey: String = API_KEY, @Query("q") search: String = "", @Query("limit") limit: Int = 10, @Query("offset") offset: Int= 10): Response<GliphyResponseModel>

}