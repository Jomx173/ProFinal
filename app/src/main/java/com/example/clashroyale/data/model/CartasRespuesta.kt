package com.example.clashroyale.data.model

data class CartasRespuesta(
    val items: List<Carta>
)

data class Carta(
    val nombre: String,
    val id: Int,
    val costoElixir: Int?,
    val urlIconos: UrlIconos?
)

data class UrlIconos(
    val medio: String?
)

