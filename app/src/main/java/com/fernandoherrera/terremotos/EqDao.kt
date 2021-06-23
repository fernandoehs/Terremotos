package com.fernandoherrera.terremotos

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
    fun borrarTerremoto (vararg : Terremoto)
    @Update
    fun actualizarTerremoto(vararg: Terremoto)
}