package com.fernandoherrera.terremotos

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface EqDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) //reemplaza id rep
    fun insertAll(eqList: MutableList<Terremoto>)

    @Query("SELECT * FROM terremotos")
    fun getTerremotos() : MutableList<Terremoto>

    @Query("SELECT * FROM terremotos WHERE magnitude > :mag ")
    fun getTerremotosConMagnitud(mag: Double) : MutableList<Terremoto>

    @Delete
    fun borrarTerremoto (vararg eq: Terremoto)
    @Update
    fun actualizarTerremoto(vararg eq: Terremoto)

    @Query("SELECT * FROM terremotos")
    fun getTerremotosLV():LiveData<MutableList<Terremoto>>

}