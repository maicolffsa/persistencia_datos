package com.example.persistencia_de_datos.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.persistencia_de_datos.db.entity.TarjetaEntity

@Dao
interface TarjetaDao {

    @Insert
    suspend fun insertar(tarjeta: TarjetaEntity)

    @Query("Select * from tarjeta order by titulo ASC")
    fun listarTarjetas(): LiveData<List<TarjetaEntity>>
}