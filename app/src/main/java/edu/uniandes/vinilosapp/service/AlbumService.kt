package edu.uniandes.vinilosapp.service

import edu.uniandes.vinilosapp.model.Album
import edu.uniandes.vinilosapp.model.jsonrequest.AlbumRequest
import edu.uniandes.vinilosapp.util.ConsumeApi
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AlbumService {

    @GET("albums")
    suspend fun getListAlbum(): List<Album>

    @POST("albums")
    suspend fun insertAlbum(@Body album: AlbumRequest): Album
}

object AlbumServiceApi{
    val serviceAlbum : AlbumService by lazy {
        ConsumeApi.retrofit().create(AlbumService::class.java)
    }
}