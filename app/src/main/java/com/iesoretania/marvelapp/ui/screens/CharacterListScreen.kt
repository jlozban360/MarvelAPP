package com.iesoretania.marvelapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.iesoretania.marvelapp.ui.components.CharacterItem
import com.iesoretania.marvelapp.ui.components.SearchBar
import com.iesoretania.marvelapp.viewmodels.MarvelViewModel

@Composable
fun CharacterListScreen(
    viewModel: MarvelViewModel,
    navController: NavController
) {
    val state by viewModel.state.collectAsState()
    val listState = rememberLazyListState()

    LaunchedEffect(listState) {
        if (listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index == state.characters.size - 1) {
            viewModel.loadCharacters()
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        SearchBar(
            onSearch = { query ->
                if (query.isNotEmpty()) viewModel.searchCharacters(query)
            }
        )

        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(state.characters) { character ->
                CharacterItem(
                    character = character,
                    onClick = { navController.navigate("details/${character.id}") }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }

            if (state.isLoading) {
                item {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .wrapContentWidth(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }
}