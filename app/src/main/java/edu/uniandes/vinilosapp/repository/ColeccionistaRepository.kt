package edu.uniandes.vinilosapp.repository

import androidx.lifecycle.LiveData
import edu.uniandes.vinilosapp.model.Coleccionista
import edu.uniandes.vinilosapp.service.serviceColeccionista
import edu.uniandes.vinilosapp.util.RoomDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ColeccionistaRepository(private val database: RoomDB) {

    val coleccionistaListFromDB: LiveData<MutableList<Coleccionista>> = database.coleccionistaDao.getAllCollector()

    suspend fun fetchCollectors() {
        return withContext(Dispatchers.IO) {
            val coleccionistaModelResponse = serviceColeccionista.getListCollectors()
            val coleccionistaLister = parseList(coleccionistaModelResponse)

            database.coleccionistaDao.insertAllCollector(coleccionistaLister)
        }
    }

    private fun parseList(colectorResponse: List<Coleccionista>): MutableList<Coleccionista> {
        val finalCollectorList = mutableListOf<Coleccionista>()

        for (colector in colectorResponse) {
            val id = colector.id
            val name = colector.name
            val email = colector.email
            val telf = colector.telephone
            finalCollectorList.add(Coleccionista(id, name, email, telf))
        }

        return finalCollectorList
    }
}