package com.example.clashroyale.data.repository

import com.example.clashroyale.data.client.ApiClient
import com.example.clashroyale.data.model.CartasRespuesta

class CartasRepository {

    suspend fun obtenerCartas(): CartasRespuesta {
        return try {
            ApiClient.api.getCards()
        } catch (e: Exception) {
            e.printStackTrace()
            CartasRespuesta() // Devuelve lista vacía si hay error
        }
    }
}
