package com.fernandoherrera.terremotos

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository {
     suspend  fun fetchTerremotos(): MutableList<Terremoto>{
        return withContext(Dispatchers.IO){

            val eqJsonResponse = service.getLastTerremoto()
            var eqList = parseEqResult(eqJsonResponse)
            eqList
            // Log.d("manzana",eqJsonResponse)
            // mutableListOf<Terremoto>()
//        val eqList = mutableListOf<Terremoto>()
//        eqList.add(Terremoto("1","Buenos Aires", 4.3, 273545845L, -102.475628,47.5132365))
//        eqList.add(Terremoto("2","Lima", 4.3, 273545845L, -102.475628,47.5132365))
//        eqList.add(Terremoto("3","Mexico", 4.3, 273545845L, -102.475628,47.5132365))
//        eqList.add(Terremoto("4","Caracas", 4.3, 273545845L, -102.475628,47.5132365))
//        eqList.add(Terremoto("5","Usa", 4.3, 273545845L, -102.475628,47.5132365))
//        eqList.add(Terremoto("6","Santiago", 4.3, 273545845L, -102.475628,47.5132365))
//        eqList.add(Terremoto("7","Los Caballeros", 4.3, 273545845L, -102.475628,47.5132365))
//
//        eqList
        }
    }

    private fun parseEqResult(eqJsonResponse:EqJsonResponse): MutableList<Terremoto>{
        val eqList = mutableListOf<Terremoto>()
        val featuresList = eqJsonResponse.features

        for (feature in featuresList){

            val properties = feature.properties

            val id = feature.id
            val magnitude = properties.mag
            val place = properties.place
            val  time = properties.time

            val geometry = feature.geometry
            val longitude = geometry.longitude
            val latitude = geometry.latitude

            eqList.add(Terremoto(id, place, magnitude, time, longitude, latitude))


        }

        return eqList

    }
}