package com.example.persistencia_de_datos.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.persistencia_de_datos.db.dao.TarjetaDao
import com.example.persistencia_de_datos.db.entity.TarjetaEntity

@Database(entities = [TarjetaEntity::class], version = 1)

public abstract class TarjetaRoomDatabase: RoomDatabase() {

    abstract fun tarjetaDao(): TarjetaDao

    companion object{
        @Volatile
        private var INSTANCE : TarjetaRoomDatabase? = null

        fun getDatabase(context: Context): TarjetaRoomDatabase{
            val tempInstance: TarjetaRoomDatabase? = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance: TarjetaRoomDatabase = Room.databaseBuilder(
                    context.applicationContext,
                    TarjetaRoomDatabase::class.java,
                    "tarjetasdb"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }


}