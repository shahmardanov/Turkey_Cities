package com.example.turkeycities.repository

import com.example.turkeycities.api.ApiService
import com.example.turkeycities.model.CityResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllCities(): Response<CityResponse> = withContext(Dispatchers.IO){
        return@withContext apiService.getAllCities()
    }
}