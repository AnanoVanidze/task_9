package com.example.retrofit.repository

import com.example.retrofit.Resource
import com.example.retrofit.api.ItemApi
import com.example.retrofit.model.Item
import javax.inject.Inject

class ItemRepository @Inject constructor(private val itemApi: ItemApi) {


    suspend fun getItems(): Resource<List<Item>> {

        return try {
            val response = itemApi.getItems()
            val result = response.body()
            if (response.isSuccessful && result != null) {
                Resource.Success(result)
            } else {
                Resource.Error(response.message())
            }
        } catch (e: Throwable) {
            Resource.Error(e.message.toString())
        }
    }

}