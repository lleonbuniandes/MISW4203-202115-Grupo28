package edu.uniandes.vinilosapp.service.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.uniandes.vinilosapp.model.Coleccionista

@Dao
interface ColeccionistaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCollector(collectorList: MutableList<Coleccionista>)

    @Query("select * from tblColeccionista")
    fun getAllCollector(): LiveData<MutableList<Coleccionista>>
}