package com.iesoretania.marvelapp.api

data class MarvelResponse(
    val code: Int,
    val status: String,
    val data: Data
) {
    data class Data(
        val offset: Int,
        val limit: Int,
        val total: Int,
        val count: Int,
        val results: List<MarvelCharacter>
    )
}

data class MarvelCharacter(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: Thumbnail
)

data class Thumbnail(
    val path: String,
    val extension: String
) {
    fun getFullImagePath(): String {
        return "${path.replace("http://", "https://")}.$extension"
    }
}