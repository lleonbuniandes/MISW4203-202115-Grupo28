package edu.uniandes.vinilosapp.repository

import androidx.lifecycle.LiveData
import edu.uniandes.vinilosapp.model.Coleccionista
import edu.uniandes.vinilosapp.model.jsonresponse.collector.CollectorResponse
import edu.uniandes.vinilosapp.service.ServiceColeccionistaApi
import edu.uniandes.vinilosapp.util.RoomDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ColeccionistaRepository(private val database: RoomDB) {

    val coleccionistaListFromDB: LiveData<MutableList<Coleccionista>> = database.coleccionistaDao.getAllCollector()

    suspend fun fetchCollectors() {
        return withContext(Dispatchers.IO) {
            database.coleccionistaDao.insertAllCollector(parseList(
                ServiceColeccionistaApi.serviceColeccionista.getListCollectors())
            )
        }
    }

    private fun parseList(colectorResponse: List<CollectorResponse>): MutableList<Coleccionista> {
        val finalCollectorList = mutableListOf<Coleccionista>()


        var name=""
        for (colector in colectorResponse) {
            if (colector.favoritePerformers.isNotEmpty()) {
                for (colectorAlbum in colector.favoritePerformers)
                    name = colectorAlbum.name!!
            }else
                name="No tiene favoritos"
            finalCollectorList.add(Coleccionista(colector.id, colector.name, colector.email, colector.telephone, name))
        }

        return finalCollectorList
    }
}