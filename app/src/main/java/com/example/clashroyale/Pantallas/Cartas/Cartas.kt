package com.example.clashroyale.ui.pantallas.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Lista de ejemplo
val cardsList = listOf(
    "P.E.K.K.A",
    "Gigante Noble",
    "Montapuercos",
    "Mega Caballero",
    "Mago",
    "Valquiria"
)

@Composable
fun CardsScreen(onCardClick: (String) -> Unit) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(cardsList) { card ->
            Text(
                text = card,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable { onCardClick(card) }
            )
        }
    }
}

