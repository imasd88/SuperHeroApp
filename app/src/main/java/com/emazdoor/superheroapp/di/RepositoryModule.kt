package com.emazdoor.superheroapp.di

import com.emazdoor.superheroapp.api.SuperheroApi
import com.emazdoor.superheroapp.repository.SuperHeroRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideSuperheroRepository(
        apiService: SuperheroApi,
        /*superheroDao: SuperheroDao*/
    ): SuperHeroRepository {
        return SuperHeroRepository(apiService/*, superheroDao*/)
    }}