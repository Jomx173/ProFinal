package com.example.clashroyale.ui.pantallas.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DetailScreen(cardName: String) {

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Título del nombre de carta
            Text(
                text = cardName,
                style = MaterialTheme.typography.headlineLarge,
                color = Color(0xFFFFD700) // dorado estilo Clash Royale
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Datos temporales de ejemplo
            Text(
                text = "🔹 Rareza: (cargando ...)",
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "🔹 Coste de Elixir: (cargando ...)",
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "🔹 Tipo de carta: (cargando ...)",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
