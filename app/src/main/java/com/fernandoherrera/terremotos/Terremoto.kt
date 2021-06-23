package com.fernandoherrera.terremotos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "terremotos")

data class Terremoto(
    @PrimaryKey var id:String, val place:String, val magnitude: Double, val time: Long,
    val longitude:Double, val latitude:Double)

