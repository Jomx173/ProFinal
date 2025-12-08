package com.example.clashroyale.data.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.clashroyale.data.model.Carta

class SharedCartaViewModel : ViewModel() {
    var cartaSeleccionada by mutableStateOf<Carta?>(null)

    fun setCarta(carta: Carta) {
        cartaSeleccionada = carta
    }
}