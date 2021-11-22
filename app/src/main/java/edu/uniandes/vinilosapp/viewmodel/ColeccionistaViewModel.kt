package edu.uniandes.vinilosapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import edu.uniandes.vinilosapp.repository.ColeccionistaRepository
import edu.uniandes.vinilosapp.util.getDatabase
import kotlinx.coroutines.launch
import java.net.UnknownHostException

private val TAG = ColeccionistaViewModel::class.java.simpleName

class ColeccionistaViewModel(application: Application) : AndroidViewModel(application) {

    private val database = getDatabase(application)
    private val repositoryColeccionista = ColeccionistaRepository(database)

    val coleccionistaList = repositoryColeccionista.coleccionistaListFromDB

    init {
        viewModelScope.launch {
            try {
                repositoryColeccionista.fetchCollectors()
            } catch (e: UnknownHostException) {
                Log.d(TAG, "not found service connection", e)
            }
        }
    }

}