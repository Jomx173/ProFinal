package com.example.clashroyale.data.repository

import com.example.clashroyale.data.client.ApiClient
import com.example.clashroyale.data.model.Player

class PlayerRepository {

    suspend fun getPlayer(tag: String): Player {
        // 🔹 Reformatear tag para API Clash Royale
        val safeTag = "%23" + tag.replace("#", "")

        return ApiClient.api.getPlayer(safeTag)
    }
}
