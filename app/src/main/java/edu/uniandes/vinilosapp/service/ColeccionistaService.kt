package edu.uniandes.vinilosapp.service

import edu.uniandes.vinilosapp.model.jsonresponse.CollectorResponse
import edu.uniandes.vinilosapp.util.ConsumeApi
import retrofit2.http.GET

interface ColeccionistaService {

    @GET("collectors")
    suspend fun getListCollectors(): List<CollectorResponse>
}

object ServiceColeccionistaApi{
    val serviceColeccionista: ColeccionistaService by lazy{
        ConsumeApi.retrofit().create(ColeccionistaService::class.java)
    }
}