package edu.uniandes.vinilosapp.util

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import edu.uniandes.vinilosapp.viewmodel.AlbumViewModel
import edu.uniandes.vinilosapp.viewmodel.ArtistaViewModel
import edu.uniandes.vinilosapp.viewmodel.ColeccionistaViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val application: Application) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass === AlbumViewModel::class.java) {
            return AlbumViewModel(application) as T
        } else if (modelClass === ArtistaViewModel::class.java) {
            return ArtistaViewModel(application) as T
        } else if (modelClass === ColeccionistaViewModel::class.java) {
            return ColeccionistaViewModel(application) as T
        }
        throw IllegalArgumentException("ViewModel desconocido")
    }


}