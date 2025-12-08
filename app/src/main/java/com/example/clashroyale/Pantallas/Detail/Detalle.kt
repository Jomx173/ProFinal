package com.example.clashroyale.Pantallas.Detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.foundation.Image
import com.example.clashroyale.data.model.Carta
import com.example.clashroyale.R
import com.example.clashroyale.ui.theme.supercell

@Composable
fun DetailScreen(carta: Carta?) {

    if (carta == null) {
        Text("No se encontró la carta")
        return
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = R.drawable.fondo_clash),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )


        Card(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xAA0F172A)), // semi transparente
            elevation = CardDefaults.cardElevation(12.dp),
            shape = RoundedCornerShape(20.dp)
        ) {

            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                AsyncImage(
                    model = carta.iconUrls.medium ?: "",
                    contentDescription = carta.name,
                    modifier = Modifier.size(180.dp)
                )

                Spacer(Modifier.height(16.dp))

                Text(text = carta.name,
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.White,
                    fontFamily = supercell
                )

                Spacer(Modifier.height(10.dp))

                Text("Rareza: ${carta.rarity}",
                    color = Color.White)
                Text("Elixir: ${carta.elixirCost}",
                    color = Color.White)
                Text("Nivel máximo: ${carta.maxLevel}",
                    color = Color.White)
            }
        }
    }
}