package edu.uniandes.vinilosapp.model.jsonrequest

data class AlbumRequest(
    val name: String,
    val description: String,
    val cover: String,
    val genre: String,
    val recordLabel: String,
    val releaseDate: String
)