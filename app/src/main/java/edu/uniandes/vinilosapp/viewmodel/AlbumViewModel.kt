package edu.uniandes.vinilosapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import edu.uniandes.vinilosapp.model.Album
import edu.uniandes.vinilosapp.repository.AlbumRepository
import edu.uniandes.vinilosapp.service.AlbumService
import edu.uniandes.vinilosapp.service.service
import edu.uniandes.vinilosapp.util.ConsumeApi
import edu.uniandes.vinilosapp.util.getDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.UnknownHostException
import java.text.SimpleDateFormat
import java.util.*

private val TAG = AlbumViewModel::class.java.simpleName
class AlbumViewModel(application: Application) : AndroidViewModel(application) {

    private val database = getDatabase(application)
    private val repositoryAlbum = AlbumRepository(database)

    val albumList = repositoryAlbum.albumListFromDB

    init {
        viewModelScope.launch {
            try {
                repositoryAlbum.fetchAlbum()
            } catch (e: UnknownHostException) {
                Log.d(TAG,"not found service connection", e)
            }
        }
    }


}