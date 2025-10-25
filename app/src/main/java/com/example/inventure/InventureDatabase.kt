package com.example.inventure

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Inventure::class], version = 1, exportSchema = false)
abstract class InventureDatabase : RoomDatabase() {
    abstract fun inventureDao(): InventureDao
}