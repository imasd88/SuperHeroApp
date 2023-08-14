package com.emazdoor.superheroapp.repository

import com.emazdoor.superheroapp.api.SuperheroApi
import com.emazdoor.superheroapp.model.Superhero
import javax.inject.Inject

class SuperHeroRepository @Inject constructor(
    private val superheroApi: SuperheroApi,
    /*private val superheroDao: SuperheroDao*/
) {
    suspend fun getAllSuperheroes(): List<Superhero> = superheroApi.getAllSuperheroes()

    suspend fun searchSuperheroes(name: String): List<Superhero> = superheroApi.searchSuperheroes(name)

    /*
    suspend fun toggleFavorite(superhero: Superhero) {
        superheroDao.toggleFavorite(superhero)
    }
    fun getFavoriteSuperheroes(): Flow<List<Superhero>> = superheroDao.getFavoriteSuperheroes()
     */

}