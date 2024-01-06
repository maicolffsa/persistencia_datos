package com.example.persistencia_de_datos.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.persistencia_de_datos.db.TarjetaRoomDatabase
import com.example.persistencia_de_datos.db.dao.TarjetaDao
import com.example.persistencia_de_datos.db.entity.TarjetaEntity
import com.example.persistencia_de_datos.repository.TarjetaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TarjetaDialogViewModel(application: Application): AndroidViewModel(application) {

    private val repository: TarjetaRepository

    init {
        val tarjetaDao: TarjetaDao = TarjetaRoomDatabase.getDatabase(application)
            .tarjetaDao()
        repository = TarjetaRepository(tarjetaDao)
    }

    fun insertar(tarjetaEntity: TarjetaEntity) = viewModelScope.launch (Dispatchers.IO){
        repository.insertar(tarjetaEntity)
    }

    fun listarTarjetas(): LiveData<List<TarjetaEntity>>{
        return repository.listarTarjetas()
    }
}