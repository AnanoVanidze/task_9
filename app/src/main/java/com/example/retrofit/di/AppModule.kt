package com.example.retrofit.di

import com.example.retrofit.api.ItemApi
import com.example.retrofit.repository.ItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideItemApi(): ItemApi = Retrofit.Builder()
        .baseUrl("https://api.spacexdata.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ItemApi::class.java)


    @Singleton
    @Provides
    fun provideItemRepository(api: ItemApi): ItemRepository = ItemRepository(api)
}