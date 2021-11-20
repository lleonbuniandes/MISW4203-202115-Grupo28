package edu.uniandes.vinilosapp.model

data class Album(
    val id: Int,
    val name: String,
    val description: String,
    val cover: String,
    val genre: String,
    val recordLabel: String,
    val releaseDate: String,
)