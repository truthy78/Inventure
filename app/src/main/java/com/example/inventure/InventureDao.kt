package com.example.inventure

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface InventureDao {

    @Query("SELECT * FROM inventures ORDER BY timestamp DESC ")
    fun getAllInventure(): Flow<List<Inventure>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInventure(inventure: Inventure)

    @Delete
    suspend fun deleteInventure(inventure: Inventure)

    @Query("DELETE FROM inventures")
    suspend fun deleteAllInventures()

}