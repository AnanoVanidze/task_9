package com.example.retrofit.api

import com.example.retrofit.model.Item

import retrofit2.http.GET

interface ItemApi {

    @GET("/v3/ships")
    suspend fun getItems(): List<Item>
}