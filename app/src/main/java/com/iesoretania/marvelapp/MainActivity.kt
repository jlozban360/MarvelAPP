package com.iesoretania.marvelapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iesoretania.marvelapp.ui.screens.CharacterDetailScreen
import com.iesoretania.marvelapp.ui.screens.CharacterListScreen
import com.iesoretania.marvelapp.viewmodels.MarvelViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarvelApp()
        }
    }
}

@Composable
fun MarvelApp() {
    val navController = rememberNavController()
    val viewModel: MarvelViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = "list"
    ) {
        composable("list") {
            CharacterListScreen(
                viewModel = viewModel,
                navController = navController
            )
        }
        composable("details/{characterId}") { backStackEntry ->
            val characterId = backStackEntry.arguments?.getString("characterId")?.toIntOrNull()
            val character = viewModel.state.value.characters.find { it.id == characterId }

            character?.let {
                CharacterDetailScreen(character = it)
            }
        }
    }
}