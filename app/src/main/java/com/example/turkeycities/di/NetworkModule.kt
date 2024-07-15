package com.example.turkeycities.di

import com.example.turkeycities.api.ApiService
import com.example.turkeycities.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
     fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(
            Constant.BASE_URL + Constant.API_REGION
        )
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
     fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}