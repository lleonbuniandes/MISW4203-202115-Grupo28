package edu.uniandes.vinilosapp.util.upload

import edu.uniandes.vinilosapp.util.ConsumeApi
import okhttp3.RequestBody
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part


interface UploadImage {
    @Headers("Authorization:306d8de3da30a2f")
    @Multipart
    @POST("upload")
    fun uploadImage(@Part("image") part: RequestBody?)
}
object UploadImageAPI {
    val serviceUploadImage: UploadImage by lazy {
        ConsumeApi.retrofit().create(UploadImage::class.java)
    }
}
