package com.example.clashroyale.ui.pantallas.jugador

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.clashroyale.data.viewmodel.PlayerViewModel

@Composable
fun JugadorScreen(vm: PlayerViewModel = viewModel()) {

    var tagInput by remember { mutableStateOf("") }

    val playerData = vm.player.collectAsState().value
    val error = vm.errorMessage.collectAsState().value

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("Buscar jugador")

        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = tagInput,
            onValueChange = { tagInput = it },
            label = { Text("Ingrese tag del jugador") }
        )

        Spacer(Modifier.height(12.dp))

        Button(onClick = {
            if (tagInput.isNotBlank()) {
                vm.loadPlayer(tagInput)
            }
        }) {
            Text("Buscar")
        }

        Spacer(Modifier.height(20.dp))

        // ⭐ mensaje de error
        error?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error
            )
        }

        // ⭐ mostrar datos del jugador
        playerData?.let {
            Spacer(Modifier.height(12.dp))
            Card {
                Column(Modifier.padding(16.dp)) {
                    Text("Nombre: ${it.name}")
                    Text("Nivel: ${it.expLevel}")
                    Text("Tag: ${it.tag}")
                }
            }
        }
    }
}
