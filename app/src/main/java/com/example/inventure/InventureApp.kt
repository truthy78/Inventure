package com.example.inventure

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InventureApp(viewModel: InventureViewModel) {
    val inventure by viewModel.inventures.collectAsState()

    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var productQuantity by remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBar(title = {Text("Inventure App")}) },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                if (name.isNotEmpty() && description.isNotEmpty() && price.isNotEmpty() && productQuantity.isNotEmpty()) {
                    viewModel.addInventure(name,description,price,productQuantity)
                    name = ""
                    description = ""
                    price = ""
                    productQuantity = ""
                }
            }) {
                Text("+")
            }
        }
    ) { padding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = {name = it},
                label = {Text("Product Name")},
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = description,
                onValueChange = { description = it},
                label = { Text("Description")},
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = price,
                onValueChange = { price = it},
                label = { Text("Price")},
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = productQuantity,
                onValueChange = { productQuantity = it},
                label = { Text("Description")},
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun InventureItem(inventure: Inventure, onDelete: () -> Unit) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ){
        Row(
            Modifier.fillMaxSize()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Column {
                Text(inventure.name, style = MaterialTheme.typography.titleMedium)
                Text(inventure.description, style = MaterialTheme.typography.titleMedium)
                Text(inventure.price, style = MaterialTheme.typography.titleMedium)
                Text(inventure.productQuantity, style = MaterialTheme.typography.titleMedium)
            }
            TextButton(onClick = onDelete) {
                Text("Delete", color = MaterialTheme.colorScheme.error)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InventureApp(onAddProduct: (Inventure) -> Unit) {
    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var productQuantity by remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBar(title = {Text("Inventure App")}) },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                if (name.isNotEmpty() && description.isNotEmpty() && price.isNotEmpty() && productQuantity.isNotEmpty()) {
                    name = ""
                    description = ""
                    price = ""
                    productQuantity = ""
                }
            }) {
                Text("+")
            }
        }
    ) { padding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = {name = it},
                label = {Text("Product Name")},
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = description,
                onValueChange = { description = it},
                label = { Text("Description")},
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = price,
                onValueChange = { price = it},
                label = { Text("Price")},
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = productQuantity,
                onValueChange = { productQuantity = it},
                label = { Text("Description")},
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun viewItemScreen(products: List<Inventure>) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text("All Products", style =MaterialTheme.typography.headlineMedium)
        if(products.isEmpty())
            Text("No products added yet")
        else LazyColumn { items(products) {InventureItem(it, onDelete = ) } }

    }

}