package edu.uniandes.vinilosapp.util

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModel
import edu.uniandes.vinilosapp.view.album.AlbumList
import edu.uniandes.vinilosapp.viewmodel.AlbumViewModel

class ViewModelFactory(private val application: Application):
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AlbumViewModel(application) as T
    }
}