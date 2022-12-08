package com.example.retrofit.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.retrofit.model.Item
import kotlinx.coroutines.flow.Flow


@Dao
interface ItemDao {

    @Query("SELECT * FROM item_table")
    fun getItems(): List<Item>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(items: List<Item>)

    @Query("DELETE FROM item_table")
    fun deleteItems()

}