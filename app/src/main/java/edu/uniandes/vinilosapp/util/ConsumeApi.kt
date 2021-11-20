package edu.uniandes.vinilosapp.util

import com.squareup.moshi.Moshi
import edu.uniandes.vinilosapp.service.AlbumService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ConsumeApi {

    private const val BASE_URL = "https://back-vinyls-populated.herokuapp.com"

    fun retrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

}