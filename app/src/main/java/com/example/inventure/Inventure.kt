package com.example.inventure

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "inventures")
data class Inventure(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val description: String,
    val price: String,
    val productQuantity: String,
    val timestamp: Long = System.currentTimeMillis()
)
