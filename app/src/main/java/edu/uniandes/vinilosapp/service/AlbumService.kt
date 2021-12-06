package edu.uniandes.vinilosapp.service

import edu.uniandes.vinilosapp.model.Album
import edu.uniandes.vinilosapp.model.jsonrequest.AlbumRequest
import edu.uniandes.vinilosapp.model.jsonresponse.track.AlbumTrack
import edu.uniandes.vinilosapp.util.ConsumeApi
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AlbumService {

    @GET("albums")
    suspend fun getListAlbum(): List<Album>

    @POST("albums")
    suspend fun insertAlbum(@Body album: AlbumRequest): Album

    @GET("albums/{id}")
    suspend fun getAlbumTrack(@Query("id") idAlbum:String):AlbumTrack
}

object AlbumServiceApi{
    val serviceAlbum : AlbumService by lazy {
        ConsumeApi.retrofit().create(AlbumService::class.java)
    }
}