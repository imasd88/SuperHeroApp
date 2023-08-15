package com.emazdoor.superheroapp

import com.emazdoor.superheroapp.mock.MockData
import com.emazdoor.superheroapp.repository.SuperHeroRepository
import com.emazdoor.superheroapp.viewmodel.SuperheroViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class SuperheroViewModelTest {

    @Mock
    private lateinit var repository: SuperHeroRepository

    lateinit var viewModel: SuperheroViewModel

    private val superheroes = listOf(MockData.getMockData())

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = SuperheroViewModel(repository)
        // Create a test dispatcher that mocks the Main dispatcher
        val testDispatcher = UnconfinedTestDispatcher()
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown() {
        // Shutdown the test dispatcher
        Dispatchers.resetMain()
    }

    @Test
    fun fetchSuperHeroes_shouldCallRepositoryGetAllSuperheroes() {
        runBlocking {
            viewModel.fetchSuperHeroes()

            Mockito.verify(repository).getAllSuperheroes()
        }
    }

    @Test
    fun getSearchedSuperHeroes_shouldCallRepositorySearchSuperheroes() {
        runBlocking {
            viewModel.getSearchedSuperHeroes("Batman")

            Mockito.verify(repository).searchSuperheroes("Batman")
        }
    }

    @Test
    fun fetchSuperHeroes_shouldUpdateSuperheroesState() {
        runBlocking {
            Mockito.`when`(repository.getAllSuperheroes())
                .thenReturn(superheroes.toList()[0])

            viewModel.fetchSuperHeroes()

            assertEquals(superheroes[0], viewModel.superheroesState.value)
        }
    }

    @Test
    fun getSearchedSuperHeroes_shouldUpdateSuperheroesState() {
        runBlocking {
            Mockito.`when`(repository.searchSuperheroes("Iron Fist"))
                .thenReturn(superheroes.toList()[0])

            viewModel.getSearchedSuperHeroes("Iron Fist")

            assertEquals(superheroes[0], viewModel.superheroesState.value)
        }
    }

    @Test
    fun getTheSuperhero_shouldReturnSuperheroesState() {
        runBlocking {
            Mockito.`when`(repository.getTheSuperhero(345))
                .thenReturn(superheroes.toList()[0])

            viewModel.getTheSuperHero(345)

            assertEquals(superheroes[0], viewModel.superheroesState.value)
        }
    }
}
