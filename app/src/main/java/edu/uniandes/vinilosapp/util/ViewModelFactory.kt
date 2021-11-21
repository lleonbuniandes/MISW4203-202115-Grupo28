package edu.uniandes.vinilosapp.util

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModel
import edu.uniandes.vinilosapp.view.album.AlbumList
import edu.uniandes.vinilosapp.viewmodel.AlbumViewModel
import edu.uniandes.vinilosapp.viewmodel.ArtistaViewModel

class ViewModelFactory(private val application: Application):
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if(modelClass === AlbumViewModel::class.java){
            return AlbumViewModel(application) as T
        }else if(modelClass === ArtistaViewModel::class.java) {
            return ArtistaViewModel(application) as T
        }
        throw IllegalArgumentException("ViewModel desconocido")
    }


}