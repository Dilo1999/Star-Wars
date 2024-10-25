package com.example.xiteb_app

import retrofit2.http.GET

// Retrofit service interface for SWAPI
interface SwapiService {
    @GET("https://swapi.dev/api/planets/")
    suspend fun getPlanets(): PlanetResponse
}
