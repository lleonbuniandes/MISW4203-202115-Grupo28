package edu.uniandes.vinilosapp.util

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.uniandes.vinilosapp.model.Album
import edu.uniandes.vinilosapp.service.AlbumDao

@Database(entities =   [Album::class], version = 1)
abstract class RoomDB: RoomDatabase() {

    abstract val albumDao: AlbumDao
}

private lateinit var INSTANCE: RoomDB

fun getDatabase(context:Context):RoomDB{
    synchronized(RoomDB::class.java){
        if(!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,RoomDB::class.java,"vinilosDB").build()
        }
    }
    return INSTANCE
}

