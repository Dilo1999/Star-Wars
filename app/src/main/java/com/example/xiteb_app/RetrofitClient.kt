package com.example.xiteb_app

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Singleton object for Retrofit instance
object RetrofitClient {
    private const val BASE_URL = "https://swapi.dev/api/planets/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val instance: SwapiService by lazy {
        retrofit.create(SwapiService::class.java)
    }
}
