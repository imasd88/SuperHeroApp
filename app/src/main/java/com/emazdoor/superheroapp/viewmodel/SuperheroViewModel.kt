package com.emazdoor.superheroapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emazdoor.superheroapp.model.Superhero
import com.emazdoor.superheroapp.repository.SuperHeroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SuperheroViewModel @Inject constructor(var repository: SuperHeroRepository) : ViewModel() {

    private val _superheroesState = MutableStateFlow<List<Superhero>>(emptyList())
    val superheroesState: StateFlow<List<Superhero>> = _superheroesState

    fun fetchSuperHeroes() {
        viewModelScope.launch {
            val superHeroes = repository.getAllSuperheroes()
            _superheroesState.value = superHeroes
        }
    }

    fun getSearchedSuperHeroes(name: String) {
        viewModelScope.launch {
            val superHeroes = repository.searchSuperheroes(name)
            _superheroesState.value = superHeroes
        }
    }
}