package com.emazdoor.superheroapp.api

import com.emazdoor.superheroapp.model.Superhero
import retrofit2.http.GET
import retrofit2.http.Query

interface SuperheroApiService {
    @GET("superheroes")
    suspend fun getAllSuperheroes(): List<Superhero>

    @GET("superheroes")
    suspend fun searchSuperheroes(@Query("name_like") name: String): List<Superhero>
}
