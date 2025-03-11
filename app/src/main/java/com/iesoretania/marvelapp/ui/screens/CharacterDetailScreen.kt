package com.iesoretania.marvelapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.iesoretania.marvelapp.api.MarvelCharacter

@Composable
fun CharacterDetailScreen(character: MarvelCharacter) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberImagePainter(character.thumbnail.getFullImagePath()),
            contentDescription = null,
            modifier = Modifier
                .size(300.dp)
                .padding(8.dp),
            contentScale = ContentScale.Crop
        )

        Text(
            text = character.name,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        Text(
            text = character.description.ifEmpty { "No description available" },
            style = MaterialTheme.typography.bodyLarge
        )
    }
}