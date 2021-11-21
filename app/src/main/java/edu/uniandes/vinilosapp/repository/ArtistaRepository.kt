package edu.uniandes.vinilosapp.repository

import androidx.lifecycle.LiveData
import edu.uniandes.vinilosapp.model.Artista
import edu.uniandes.vinilosapp.model.jsonresponse.ArtistaAlbum
import edu.uniandes.vinilosapp.service.serviceArtista
import edu.uniandes.vinilosapp.util.RoomDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ArtistaRepository(private val database: RoomDB) {

    val artistaListFromDB: LiveData<MutableList<Artista>> = database.artistDao.getAllArtist()

    suspend fun fetchArtist() {
        return withContext(Dispatchers.IO) {
            val artistModelResponse = serviceArtista.getListArtists()
            val artistLister = parserList(artistModelResponse)

            database.artistDao.insertAllArtist(artistLister)
        }
    }

    private fun parserList(artistaResponse: List<ArtistaAlbum>): MutableList<Artista> {
        val finalArtistList = mutableListOf<Artista>()

        for (artista in artistaResponse) {
            val id = artista.id
            val name = artista.name
            val description = artista.description
            val image = artista.image
            val birthDate = artista.birthDate

            var numAlbum = 0
            for (album in artista.albums) {
                if (!album.description.isNullOrEmpty()) numAlbum += 1
            }

            finalArtistList.add(Artista(id, name, image, birthDate, numAlbum, description))
        }

        return finalArtistList
    }

}
