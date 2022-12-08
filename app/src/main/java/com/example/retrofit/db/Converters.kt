package com.example.retrofit.db

import androidx.room.TypeConverter
import com.example.retrofit.model.Mission
import com.example.retrofit.model.Position
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {


    @TypeConverter
    fun fromPositionToGson(position: Position): String{
        return Gson().toJson(position)
    }


    @TypeConverter
    fun gsonToPosition(json: String): Position{

        val typeToken = object : TypeToken<Position>() {}.type
        return Gson().fromJson(json, typeToken)
    }



    @TypeConverter
    fun fromListMissionToString(list: ArrayList<Mission>): String{
        return Gson().toJson(list)
    }


    @TypeConverter
    fun stringToListMission(json: String): ArrayList<Mission> {

        val typeToken = object : TypeToken<ArrayList<Mission> >() {}.type
        return Gson().fromJson(json, typeToken)
    }

    @TypeConverter
    fun fromListToString(list: ArrayList<String>): String{
        return Gson().toJson(list)
    }


    @TypeConverter
    fun stringToList(json: String): ArrayList<String> {

        val typeToken = object : TypeToken<ArrayList<String>>() {}.type
        return Gson().fromJson(json, typeToken)
    }


}