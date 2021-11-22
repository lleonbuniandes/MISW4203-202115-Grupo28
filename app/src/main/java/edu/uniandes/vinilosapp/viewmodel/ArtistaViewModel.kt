package edu.uniandes.vinilosapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import edu.uniandes.vinilosapp.repository.ArtistaRepository
import edu.uniandes.vinilosapp.util.getDatabase
import kotlinx.coroutines.launch
import java.net.UnknownHostException


private val TAG = ArtistaViewModel::class.java.simpleName

class ArtistaViewModel(application: Application) : AndroidViewModel(application) {

    private val database = getDatabase(application)
    private val repositoryArtista = ArtistaRepository(database)

    val artistaList = repositoryArtista.artistaListFromDB

    init {
        viewModelScope.launch {
            try {
                repositoryArtista.fetchArtist()
            } catch (e: UnknownHostException) {
                Log.d(TAG, "not found service connection", e)
            }
        }
    }

}