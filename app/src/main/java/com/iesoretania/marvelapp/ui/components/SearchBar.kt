package com.iesoretania.marvelapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    onSearch: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var query by remember { mutableStateOf("") }

    TextField(
        value = query,
        onValueChange = {
            query = it
            onSearch(it)
        },
        placeholder = {
            Text("Busca tu personaje de Marvel favorito...", style = MaterialTheme.typography.bodyMedium)
        },
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .statusBarsPadding()
            .padding(8.dp),
        singleLine = true
    )
}

@Preview
@Composable
fun SearchBarPreview() {
    SearchBar(onSearch = { /* handle search */ })
}
