package edu.uniandes.vinilosapp.repository

import androidx.lifecycle.LiveData
import edu.uniandes.vinilosapp.model.Album
import edu.uniandes.vinilosapp.service.AlbumServiceApi
import edu.uniandes.vinilosapp.util.RoomDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AlbumRepository(private val database: RoomDB) {

    val albumListFromDB: LiveData<MutableList<Album>> = database.albumDao.getAllAlbums()

    suspend fun fetchAlbum() {
        return withContext(Dispatchers.IO) {
            database.albumDao.insertAllAlbum(parserList(AlbumServiceApi.serviceAlbum.getListAlbum()))
        }
    }

    private fun parserList(albumModel: List<Album>): MutableList<Album> {
        val finalAlbumList = mutableListOf<Album>()

        albumModel.forEach { album ->
            finalAlbumList.add(
                Album(
                    album.id,
                    album.name,
                    album.description,
                    album.cover,
                    album.genre,
                    album.recordLabel,
                    album.releaseDate
                )
            )
        }
        return finalAlbumList

    }
}