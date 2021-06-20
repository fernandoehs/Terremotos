package com.fernandoherrera.terremotos

data class Terremoto(
    var id:String, val place:String, val magnitude: Double, val time: Long,
    val longitude:Double, val latitude:Double)