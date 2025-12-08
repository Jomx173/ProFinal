package com.example.clashroyale.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clashroyale.data.model.Player
import com.example.clashroyale.data.repository.PlayerRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PlayerViewModel : ViewModel() {

    private val repo = PlayerRepository()

    private val _player = MutableStateFlow<Player?>(null)
    val player: StateFlow<Player?> = _player

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun loadPlayer(tag: String) {
        viewModelScope.launch {
            try {
                _player.value = repo.getPlayer(tag)
                _errorMessage.value = null // limpiar error si funciona
            } catch (e: Exception) {
                e.printStackTrace()
                _player.value = null
                _errorMessage.value = "Jugador no encontrado o Tag inválido"
            }
        }
    }
}
