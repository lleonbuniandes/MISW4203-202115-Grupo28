package edu.uniandes.vinilosapp.util

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.uniandes.vinilosapp.model.Album
import edu.uniandes.vinilosapp.model.Artista
import edu.uniandes.vinilosapp.model.Coleccionista
import edu.uniandes.vinilosapp.service.dao.AlbumDao
import edu.uniandes.vinilosapp.service.dao.ArtistaDao
import edu.uniandes.vinilosapp.service.dao.ColeccionistaDao

@Database(entities = [Album::class, Artista::class, Coleccionista::class], version = 4)
abstract class RoomDB : RoomDatabase() {

    abstract val albumDao: AlbumDao
    abstract val artistDao: ArtistaDao
    abstract val coleccionistaDao: ColeccionistaDao
}

private lateinit var INSTANCE: RoomDB

fun getDatabase(context: Context): RoomDB {
    synchronized(RoomDB::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE =
                Room.databaseBuilder(context.applicationContext, RoomDB::class.java, "vinilosDB")
                    .fallbackToDestructiveMigration().build()
        }
    }
    return INSTANCE
}

