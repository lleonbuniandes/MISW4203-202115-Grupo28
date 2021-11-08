package edu.uniandes.vinilosapp.models.services

import android.app.Application
import com.android.volley.VolleyError
import edu.uniandes.vinilosapp.models.ArtistaModel

class ArtistaRepository (val application: Application) {

    fun getArtistas(callback: (List<ArtistaModel>)->Unit, onError: (VolleyError)->Unit) {
        ServiceAdapter.getInstance(application).getArtistas({
            callback(it)},
            onError
        )
    }
}