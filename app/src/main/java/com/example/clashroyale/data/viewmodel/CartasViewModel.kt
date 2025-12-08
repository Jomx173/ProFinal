package com.example.clashroyale.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clashroyale.data.model.Carta
import com.example.clashroyale.data.repository.CartasRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CartasViewModel(
    private val repository: CartasRepository = CartasRepository()
) : ViewModel() {

    private val _cartas = MutableStateFlow<List<Carta>>(emptyList())
    val cartas: StateFlow<List<Carta>> = _cartas

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        obtenerCartas()
    }

    fun obtenerCartas() {
        viewModelScope.launch {
            _loading.value = true
            try {
                val respuesta = repository.obtenerCartas()
                _cartas.value = respuesta.items
                _error.value = null
            } catch (e: Exception) {
                e.printStackTrace()
                _error.value = "Error al cargar cartas"
            } finally {
                _loading.value = false
            }
        }
    }
}
