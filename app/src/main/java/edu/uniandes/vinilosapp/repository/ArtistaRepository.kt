package edu.uniandes.vinilosapp.repository

import androidx.lifecycle.LiveData
import edu.uniandes.vinilosapp.model.Artista
import edu.uniandes.vinilosapp.model.jsonresponse.ArtistaAlbum
import edu.uniandes.vinilosapp.service.ArtistaServiceApi
import edu.uniandes.vinilosapp.util.RoomDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ArtistaRepository(private val database: RoomDB) {

    val artistaListFromDB: LiveData<MutableList<Artista>> = database.artistDao.getAllArtist()

    suspend fun fetchArtist() {
        return withContext(Dispatchers.IO) {
            val artistModelResponse = ArtistaServiceApi.serviceArtista.getListArtists()
            val artistLister = parserList(artistModelResponse)

            database.artistDao.insertAllArtist(artistLister)
        }
    }

    private fun parserList(artistaResponse: List<ArtistaAlbum>): MutableList<Artista> {
        val finalArtistList = mutableListOf<Artista>()

        artistaResponse.forEach { artista ->
            var numAlbum = 0
            artista.albums
                .filterNot { it.description.isEmpty() }
                .forEach { numAlbum += 1 }

            finalArtistList.add(Artista(artista.id, artista.name, artista.image, artista.birthDate, numAlbum, artista.description))
        }

        return finalArtistList
    }

}
