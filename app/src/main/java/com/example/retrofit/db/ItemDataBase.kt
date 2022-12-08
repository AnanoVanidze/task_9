package com.example.retrofit.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.retrofit.model.Item


@Database(entities = [Item::class], version = 1)
@TypeConverters(Converters::class)
abstract class ItemDataBase: RoomDatabase(){

    abstract val dao: ItemDao

//    companion object {
//
//        @Volatile
//        private var INSTANCE: ItemDataBase? = null
//
//        fun getDatabase(context: Context): ItemDataBase {
//
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    ItemDataBase::class.java,
//                    "item_database"
//                ).build()
//                INSTANCE = instance
//                instance
//            }
//        }
//    }
}