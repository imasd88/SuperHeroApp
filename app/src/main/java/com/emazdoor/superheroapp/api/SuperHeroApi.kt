package com.emazdoor.superheroapp.api

import com.emazdoor.superheroapp.model.Superhero
import retrofit2.http.GET
import retrofit2.http.Query

interface SuperheroApi {
    @GET("superheroes")
    suspend fun getAllSuperheroes(): List<Superhero>

    @GET("superheroes")
    suspend fun searchSuperheroes(@Query("name_like") name: String): List<Superhero>

    @GET("superheroes")
    suspend fun getTheSuperhero(@Query("id") id: Int): List<Superhero>
    /*http://localhost:1337/superheroes?id=2 request response is an array*/
}
