package edu.uniandes.vinilosapp.model.jsonresponse

import edu.uniandes.vinilosapp.model.Album


data class ArtistaAlbum(
    val id: Int,
    val name: String,
    val image: String,
    val birthDate: String,
    val albums: MutableList<Album>,
    val description: String
)