package edu.uniandes.vinilosapp.service

import edu.uniandes.vinilosapp.model.jsonresponse.ArtistaAlbum
import edu.uniandes.vinilosapp.util.ConsumeApi
import retrofit2.http.GET

interface ArtistaService {

    @GET("musicians")
    suspend fun getListArtists(): List<ArtistaAlbum>
}
var serviceArtista: ArtistaService = ConsumeApi.retrofit().create(ArtistaService::class.java)