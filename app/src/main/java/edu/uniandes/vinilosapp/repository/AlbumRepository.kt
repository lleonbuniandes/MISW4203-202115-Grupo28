package edu.uniandes.vinilosapp.repository

import androidx.lifecycle.LiveData
import edu.uniandes.vinilosapp.model.Album
import edu.uniandes.vinilosapp.model.jsonrequest.AlbumRequest
import edu.uniandes.vinilosapp.model.jsonresponse.track.AlbumTrack
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

    suspend fun createAlbum(album:AlbumRequest): Album{
        return withContext(Dispatchers.IO) {
            val response = AlbumServiceApi.serviceAlbum.insertAlbum(album)
            response
        }
    }

    suspend fun getTracksByAlbumId(id:String): AlbumTrack {
        return withContext(Dispatchers.IO) {
            val response = AlbumServiceApi.serviceAlbum.getAlbumTrack(id)
            response
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