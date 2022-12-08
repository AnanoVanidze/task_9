package com.example.retrofit.model


import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "item_table")
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @SerializedName("active")
    val active: Boolean?,
    @SerializedName("class")
    val classX: Int?,
    @SerializedName("home_port")
    val homePort: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("missions")
    val missions: ArrayList<Mission>,
    @SerializedName("position")
    val position: Position,
    @SerializedName("roles")
    val roles: ArrayList<String>,
    @SerializedName("ship_id")
    val shipId: String?,
    @SerializedName("ship_model")
    val shipModel: String?,
    @SerializedName("ship_name")
    val shipName: String?,
    @SerializedName("ship_type")
    val shipType: String?,
    @SerializedName("year_built")
    val yearBuilt: Int?
){


}