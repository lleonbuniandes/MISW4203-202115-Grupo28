package edu.uniandes.vinilosapp.service.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.uniandes.vinilosapp.model.Album

@Dao
interface AlbumDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllAlbum(albumList: MutableList<Album>)

    @Query("select * from tblAlbum")
    fun getAllAlbums(): LiveData<MutableList<Album>>
}