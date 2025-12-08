package com.example.clashroyale.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize   // ← ESTE es el correcto

data class CartasRespuesta(
    val items: List<Carta> = emptyList()
)

@Parcelize
data class Carta(
    val id: Int = 0,
    val name: String = "",
    val maxLevel: Int = 0,
    val rarity: String? = null,
    val elixir: Int? = null,
    val type: String? = null,
    val iconUrls: IconUrls = IconUrls()
) : Parcelable

@Parcelize
data class IconUrls(
    val medium: String? = null
) : Parcelable
