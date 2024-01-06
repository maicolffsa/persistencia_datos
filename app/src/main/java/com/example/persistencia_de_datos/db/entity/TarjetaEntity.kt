package com.example.persistencia_de_datos.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tarjeta")
data class TarjetaEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val titulo: String,
    val contenido: String,
    val importante: Boolean,
    val color: String
)