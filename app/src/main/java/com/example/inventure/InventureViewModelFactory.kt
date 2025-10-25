package com.example.inventure

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class InventureViewModelFactory(private val repository: InventureRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(InventureViewModel::class.java)) {
            InventureViewModel(repository) as T
        }else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}