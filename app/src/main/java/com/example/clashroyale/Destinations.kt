package com.example.clashroyale

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star

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
    Eventos(
        route = "eventos",
        label = "Eventos",
        icon = Icons.Default.Star,
        description = "Eventos del juego"
    ),
    Ubicaciones(
        route = "ubicaciones",
        label = "Ubicaciones",
        icon = Icons.Default.Star,
        description = "Lugares del juego"
    ),

    Detail(
    route = "detail",   //<--- ESTE NOMBRE IMPORTA
    label = "Detalle",
    icon = Icons.Default.Star,
    description = "Detalles de carta"
    )


}
