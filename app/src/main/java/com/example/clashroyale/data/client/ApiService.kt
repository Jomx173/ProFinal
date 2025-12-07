package com.example.clashroyale.data.client

import com.example.clashroyale.data.model.CartasRespuesta
import retrofit2.http.GET

interface ApiService {

    @GET("v1/cards")
    suspend fun getCartas(): CartasRespuesta
}



