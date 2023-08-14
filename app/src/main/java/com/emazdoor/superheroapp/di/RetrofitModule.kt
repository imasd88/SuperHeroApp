package com.emazdoor.superheroapp.di

import com.emazdoor.superheroapp.api.SuperheroApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.0.100:1337/") // Base url of the API. Using my local IP address to avoid CORS error
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @Singleton
    fun provideSuperheroApiService(retrofit: Retrofit): SuperheroApi {
        return retrofit.create(SuperheroApi::class.java)
    }
}