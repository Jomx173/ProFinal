package com.example.clashroyale.ui.pantallas.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.clashroyale.Destinations   // IMPORTANTE

@Composable
fun HomeScreen(onNavigate: (String) -> Unit) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(onClick = { onNavigate(Destinations.Cards.route) }) {
            Text("Ir a Cartas")
        }

        Spacer(Modifier.height(16.dp))

        Button(onClick = { onNavigate(Destinations.Eventos.route) }) {
            Text("Ver Eventos")
        }

        Spacer(Modifier.height(16.dp))

        Button(onClick = { onNavigate(Destinations.Ubicaciones.route) }) {
            Text("Ver Ubicaciones")
        }

        Spacer(Modifier.height(16.dp))

        // ⭐ Nuevo botón integrado aquí
        Button(onClick = { onNavigate(Destinations.Jugador.route) }) {
            Text("Buscar Jugador")
        }
    }
}
