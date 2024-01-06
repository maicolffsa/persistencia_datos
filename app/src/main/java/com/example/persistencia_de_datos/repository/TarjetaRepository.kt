package com.example.persistencia_de_datos.repository

import androidx.lifecycle.LiveData
import com.example.persistencia_de_datos.db.dao.TarjetaDao
import com.example.persistencia_de_datos.db.entity.TarjetaEntity

class TarjetaRepository(private val tarjetaDao: TarjetaDao) {

    suspend fun insertar(tarjetaEntity: TarjetaEntity){
        tarjetaDao.insertar(tarjetaEntity)
    }

    fun listarTarjetas(): LiveData<List<TarjetaEntity>>{
        return tarjetaDao.listarTarjetas()
    }

}