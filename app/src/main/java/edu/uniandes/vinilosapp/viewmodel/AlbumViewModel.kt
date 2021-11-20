package edu.uniandes.vinilosapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.uniandes.vinilosapp.model.Album
import edu.uniandes.vinilosapp.service.AlbumService
import edu.uniandes.vinilosapp.service.service
import edu.uniandes.vinilosapp.util.ConsumeApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AlbumViewModel: ViewModel() {

    private var _albumList = MutableLiveData<MutableList<Album>>()
    val albumList:LiveData<MutableList<Album>>
    get() = _albumList

    init {
        viewModelScope.launch {
            _albumList.value = fetchAlbum()
        }
    }

    private suspend fun fetchAlbum(): MutableList<Album> {
        return withContext(Dispatchers.IO) {
            val albumModel = service.getListAlbum()
            val albumLister = parserList(albumModel)
            albumLister
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