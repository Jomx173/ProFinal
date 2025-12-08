package com.example.clashroyale.ui.pantallas.cartas

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import androidx.compose.ui.res.painterResource
import com.example.clashroyale.R
import com.example.clashroyale.data.model.Carta
import com.example.clashroyale.data.viewmodel.CartasViewModel
import com.example.clashroyale.ui.theme.supercell

@Composable
fun CartasGridScreen(
    viewModel: CartasViewModel = viewModel(),
    onCardClick: (Carta) -> Unit = {}
) {

    val cartas by viewModel.cartas.collectAsState()
    val loading by viewModel.loading.collectAsState()
    val error by viewModel.error.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {

        Text(
            text = "Cartas",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(16.dp)
        )

        when {
            loading -> CircularProgressIndicator(modifier = Modifier.padding(16.dp))
            error != null -> Text(
                text = "⚠ Error: $error",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(16.dp)
            )
            else -> {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 8.dp),
                    contentPadding = PaddingValues(vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(cartas) { carta ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { onCardClick(carta) },
                            elevation = CardDefaults.cardElevation(6.dp)
                        ) {
                            Column(
                                modifier = Modifier.padding(8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                AsyncImage(
                                    model = carta.iconUrls.medium ?: "",
                                    contentDescription = carta.name,
                                    modifier = Modifier.size(90.dp),
                                    error = painterResource(R.drawable.ic_launcher_foreground)
                                )

                                Spacer(modifier = Modifier.height(6.dp))

                                Text(
                                    text = carta.name,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontFamily = supercell
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
