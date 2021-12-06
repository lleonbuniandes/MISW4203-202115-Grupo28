package edu.uniandes.vinilosapp.service

import edu.uniandes.vinilosapp.model.jsonresponse.album.ArtistaAlbum
import edu.uniandes.vinilosapp.util.ConsumeApi
import retrofit2.http.GET

interface ArtistaService {

    @GET("musicians")
    suspend fun getListArtists(): List<ArtistaAlbum>
}
object ArtistaServiceApi{
    val serviceArtista : ArtistaService by lazy {
        ConsumeApi.retrofit().create(ArtistaService::class.java)
    }
}