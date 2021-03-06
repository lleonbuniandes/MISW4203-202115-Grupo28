package edu.uniandes.vinilosapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import edu.uniandes.vinilosapp.model.Album
import edu.uniandes.vinilosapp.model.jsonrequest.AlbumRequest
import edu.uniandes.vinilosapp.model.jsonresponse.track.AlbumTrack
import edu.uniandes.vinilosapp.repository.AlbumRepository
import edu.uniandes.vinilosapp.util.getDatabase
import kotlinx.coroutines.launch
import java.net.UnknownHostException

private val TAG = AlbumViewModel::class.java.simpleName

class AlbumViewModel(application: Application) : AndroidViewModel(application) {

    private val database = getDatabase(application)
    private val repositoryAlbum = AlbumRepository(database)

    val albumList = repositoryAlbum.albumListFromDB

    private val _newAlbum = MutableLiveData<Album>()
    val status: LiveData<Album>
    get() = _newAlbum

    private val trackAlbum = MutableLiveData<AlbumTrack>()
    val track:LiveData<AlbumTrack>
    get()= trackAlbum


    init {
        viewModelScope.launch {
            try {
                repositoryAlbum.fetchAlbum()
            } catch (e: UnknownHostException) {
                Log.d(TAG, "not found service connection", e)
            }
        }
    }

    fun createAlbum(album: AlbumRequest){
         viewModelScope.launch {
             _newAlbum.value = repositoryAlbum.createAlbum(album)
         }
    }

    fun getTracksByAlbumId(albumId: String){
        viewModelScope.launch{
            trackAlbum.value = repositoryAlbum.getTracksByAlbumId(albumId)
        }
    }
}