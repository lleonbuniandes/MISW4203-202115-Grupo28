package edu.uniandes.vinilosapp.view_models

import android.app.Application
import androidx.lifecycle.*
import edu.uniandes.vinilosapp.models.ArtistaModel
import edu.uniandes.vinilosapp.models.services.ArtistaRepository

class ArtistaViewModel (application: Application) : AndroidViewModel(application) {
    private val _artistas = MutableLiveData<List<ArtistaModel>>()
    val artistas: LiveData<List<ArtistaModel>> get() = _artistas

    private var _eventNetworkError = MutableLiveData<Boolean>(false)
    val eventNetworkError: LiveData<Boolean> get() = _eventNetworkError
    private var _isNetworkErrorShown = MutableLiveData<Boolean>(false)
    val isNetworkErrorShown: LiveData<Boolean> get() = _isNetworkErrorShown

    private val albumRepository = ArtistaRepository(application)

    init {
        refreshDataFromNetwork()
    }

    private fun refreshDataFromNetwork() {
        albumRepository.getArtistas({list ->
            _artistas.postValue(list)
            _eventNetworkError.value = false
            _isNetworkErrorShown.value = false
        },{
            _eventNetworkError.value = true
        })
    }

    fun onNetworkErrorShown() {
        _isNetworkErrorShown.value = true
    }

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ArtistaViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ArtistaViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}