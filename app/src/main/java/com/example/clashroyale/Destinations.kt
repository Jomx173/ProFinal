package com.example.clashroyale

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import com.example.clashroyale.data.model.Carta



enum class Destinations(
    val route: String,
    val label: String,
    val icon: ImageVector,
    val description: String
) {
    Home(
        route = "home",
        label = "Inicio",
        icon = Icons.Default.Home,
        description = "Pantalla principal"
    ),

    Cards(
        route = "cards",
        label = "Cartas",
        icon = Icons.Default.List,
        description = "Lista de cartas"
    ),

    Detail(
        route = "detail/{cardName}", // 🔥 ruta dinámica
        label = "Detalle",
        icon = Icons.Default.Star,
        description = "Detalles de carta"
    ),



    Jugador(
        route = "jugador",
        label = "Jugador",
        icon = Icons.Default.Star,
        description = "Buscar perfil de jugador"
    );

    // 🔥 helper para construir ruta
    fun buildDetailRoute(cardName: Carta) = "detail/$cardName"
}
