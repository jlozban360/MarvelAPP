package com.iesoretania.marvelapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.iesoretania.marvelapp.api.MarvelCharacter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetailScreen(
    character: MarvelCharacter,
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(character.name) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Imagen del personaje
            Image(
                painter = rememberAsyncImagePainter(character.thumbnail.getFullImagePath()),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Descripción del personaje
            Text(
                text = character.description.ifEmpty { "Ninguna descripción disponible." },
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Justify
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Botón para volver al inicio
            Button(
                onClick = {
                    // Navega a la ruta "list" y limpia el backstack si es necesario
                    navController.navigate("list") {
                        popUpTo("list") { inclusive = true }
                    }
                },
                modifier = Modifier
                    //.fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .width(150.dp)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,  // Color del fondo
                    contentColor = Color.White   // Color del texto
                )
            ) {
                Text("Volver al inicio")
            }
        }
    }
}
