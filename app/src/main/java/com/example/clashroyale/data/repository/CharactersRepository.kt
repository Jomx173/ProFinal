package com.example.clashroyale.data.repositorio

import com.example.clashroyale.data.client.ApiClient

class CartasRepositorio {

    suspend fun obtenerCartas() =
        ApiClient.api.getCartas()
}
