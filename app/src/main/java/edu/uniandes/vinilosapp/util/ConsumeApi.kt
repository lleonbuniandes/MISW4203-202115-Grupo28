package edu.uniandes.vinilosapp.util

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object ConsumeApi {

    private const val BASE_URL = "https://back-vinyls-populated.herokuapp.com/"
    private const val BASE_URL_UPLOAD_IMG = "https://api.imgur.com/3/"

    fun retrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    fun retrofitUploadImage(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL_UPLOAD_IMG)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
}