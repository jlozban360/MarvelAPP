package com.iesoretania.marvelapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iesoretania.marvelapp.api.MarvelAPI
import com.iesoretania.marvelapp.api.MarvelCharacter
import com.iesoretania.marvelapp.utils.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MarvelViewModel : ViewModel() {
    private val api: MarvelAPI = RetrofitClient.instance

    private val _state = MutableStateFlow(MarvelState())
    val state = _state.asStateFlow()

    private val ts = "1"
    private val publicKey = "e5f710e76dfee78519998018c1a6b415"
    private val hash = "dc93bfdd6593246f55ce3555681b036f"

    init {
        loadCharacters()
    }

    fun loadCharacters() {
        if (_state.value.isLoading) return

        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            try {
                val response = api.getCharacters(
                    ts = ts,
                    apikey = publicKey,
                    hash = hash,
                    limit = 20,
                    offset = _state.value.characters.size
                )

                if (response.code == 200) {
                    _state.update {
                        it.copy(
                            characters = it.characters + response.data.results,
                            isLoading = false
                        )
                    }
                }
            } catch (e: Exception) {
                _state.update { it.copy(error = e.message, isLoading = false) }
            }
        }
    }

    fun searchCharacters(query: String) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            try {
                val response = api.searchCharacters(
                    ts = ts,
                    apikey = publicKey,
                    hash = hash,
                    limit = 100,
                    nameStartsWith = query
                )

                if (response.code == 200) {
                    _state.update {
                        it.copy(
                            characters = response.data.results,
                            isLoading = false
                        )
                    }
                }
            } catch (e: Exception) {
                _state.update { it.copy(error = e.message, isLoading = false) }
            }
        }
    }
}

data class MarvelState(
    val characters: List<MarvelCharacter> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)