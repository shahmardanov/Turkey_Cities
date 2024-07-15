package com.example.turkeycities.api

import com.example.turkeycities.model.CityResponse
import com.example.turkeycities.util.Constant
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("service/museum/cities")
    suspend fun getAllCities(@Query("apiKey") apiKey: String = Constant.API_KEY): Response<CityResponse>

}