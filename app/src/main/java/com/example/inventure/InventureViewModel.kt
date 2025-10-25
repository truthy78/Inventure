package com.example.inventure

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class InventureViewModel(private val repository: InventureRepository) : ViewModel() {


    val inventures = repository.allInventures.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

    fun addInventure(name: String, description: String, price: String, productQuantity: String) {
        viewModelScope.launch {
            repository.addInventure(Inventure(name = name, description = description, price = price, productQuantity = productQuantity))
        }
    }

    fun delete(inventure: Inventure){
        viewModelScope.launch {
            repository.delete(inventure)
        }
    }

    fun clearAll() {
        viewModelScope.launch {
            repository.clearAll()
        }
    }
}