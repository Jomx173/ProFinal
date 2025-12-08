package com.example.clashroyale.ui.pantallas.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.clashroyale.Destinations
import com.example.clashroyale.R
import com.example.clashroyale.ui.theme.supercell

@Composable
fun HomeScreen(onNavigate: (String) -> Unit) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.fondo_principar),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = { onNavigate(Destinations.Cards.route) }) {
                Text("Ir a Cartas", fontFamily = supercell)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { onNavigate(Destinations.Jugador.route) }) {
                Text("Buscar Jugador", fontFamily = supercell)
            }
        }
    }
}