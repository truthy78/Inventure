package com.example.inventure

import kotlinx.coroutines.flow.Flow

class InventureRepository(private val dao: InventureDao) {

    val allInventures: Flow<List<Inventure>> = dao.getAllInventure()

    suspend fun addInventure(inventure: Inventure) {
        dao.insertInventure(inventure)
    }

    suspend fun delete(inventure: Inventure) {
        dao.deleteInventure(inventure)
    }

    suspend fun clearAll() {
        dao.deleteAllInventures()
    }
}