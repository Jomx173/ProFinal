package com.example.clashroyale.ui.pantallas.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DetailScreen(cardName: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Detalles de $cardName",
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(Modifier.height(20.dp))
        Text(" Rareza: (ejemplo)")
        Text("Elixir: (ejemplo)")
        Text("Info: (ejemplo)")
    }
}

