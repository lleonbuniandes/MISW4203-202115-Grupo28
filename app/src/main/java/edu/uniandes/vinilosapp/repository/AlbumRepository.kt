package edu.uniandes.vinilosapp.repository

import androidx.lifecycle.LiveData
import edu.uniandes.vinilosapp.model.Album
import edu.uniandes.vinilosapp.service.service
import edu.uniandes.vinilosapp.util.RoomDB
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AlbumRepository(private val database: RoomDB) {

    val albumListFromDB: LiveData<MutableList<Album>> = database.albumDao.getAllAlbums()

    suspend fun fetchAlbum() {
        return withContext(Dispatchers.IO) {
            val albumModel = service.getListAlbum()
            val albumLister = parserList(albumModel)

            database.albumDao.insertAllAlbum(albumLister)
        }
    }

    private fun parserList(albumModel: List<Album>): MutableList<Album> {
        val finalAlbumList = mutableListOf<Album>()

        for (album in albumModel){
            val id = album.id
            val name = album.name
            val description = album.description
            val cover = album.cover
            val genre = album.genre
            val recordLabel = album.recordLabel
            val dateReleased = album.releaseDate

            finalAlbumList.add(Album(id,name,description,cover,genre,recordLabel,dateReleased))
        }
        return finalAlbumList

    }
}