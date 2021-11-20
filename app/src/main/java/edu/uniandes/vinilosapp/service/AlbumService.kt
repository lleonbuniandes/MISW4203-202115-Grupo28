package edu.uniandes.vinilosapp.service

import edu.uniandes.vinilosapp.model.Album
import edu.uniandes.vinilosapp.util.ConsumeApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface AlbumService {

    @GET("albums")
    suspend fun getListAlbum(): List<Album>
}

var service: AlbumService = ConsumeApi.retrofit().create<AlbumService>(AlbumService::class.java)

