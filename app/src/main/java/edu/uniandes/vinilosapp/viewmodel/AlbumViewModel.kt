package edu.uniandes.vinilosapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import edu.uniandes.vinilosapp.repository.AlbumRepository
import edu.uniandes.vinilosapp.util.getDatabase
import kotlinx.coroutines.launch
import java.net.UnknownHostException

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
                Log.d(TAG, "not found service connection", e)
            }
        }
    }


}