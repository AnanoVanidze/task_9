package com.example.retrofit.repository

import com.example.retrofit.Resource
import com.example.retrofit.api.ItemApi
import com.example.retrofit.db.ItemDao
import com.example.retrofit.db.ItemDataBase
import com.example.retrofit.model.Item
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

import javax.inject.Inject

class ItemRepository @Inject constructor(private val itemApi: ItemApi, private val itemDao: ItemDao) {


    suspend fun getItems(): Flow<Resource<List<Item>>> = flow{

        emit(Resource.Loading())

        val getItemsFromDb = itemDao.getItems()
        emit(Resource.Loading(data = getItemsFromDb))

        try {
            val remoteData = itemApi.getItems()
            itemDao.deleteItems()
            itemDao.insertItems(remoteData)

        }catch (e: IOException){
            emit(Resource.Error("some error"))

        }catch (e: HttpException){
            emit(Resource.Error("check internet connection"))

        }


        val newItems = itemDao.getItems()
        emit(Resource.Success(newItems))









    }


}