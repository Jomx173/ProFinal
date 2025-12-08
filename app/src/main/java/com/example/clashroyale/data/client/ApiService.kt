package com.example.clashroyale.data.client

import com.example.clashroyale.data.model.CartasRespuesta
import com.example.clashroyale.data.model.Player
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("v1/cards")
    suspend fun getCartas(): CartasRespuesta

    @GET("v1/players/{tag}")
    suspend fun getPlayer(@Path("tag") tag: String): Player


}



