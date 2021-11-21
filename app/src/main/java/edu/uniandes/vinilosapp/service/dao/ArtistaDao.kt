package edu.uniandes.vinilosapp.service.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.uniandes.vinilosapp.model.Artista

@Dao
interface ArtistaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllArtist(artistList: MutableList<Artista>)

    @Query("select * from tblArtista")
    fun getAllArtist(): LiveData<MutableList<Artista>>

}