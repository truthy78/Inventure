package com.example.inventure

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import com.example.inventure.ui.theme.InventureTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val db = Room.databaseBuilder(
            applicationContext,
            InventureDatabase::class.java,
            "note_db"
        ).build()

        val repository = InventureRepository(db.inventureDao())
        val viewModelFactory = InventureViewModelFactory(repository)

        setContent {
            val inventureViewModel: InventureViewModel = viewModel(factory = viewModelFactory)
            InventureApp(inventureViewModel)
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    InventureApp()
}