package edu.uniandes.vinilosapp.model.jsonresponse.track

data class AlbumTrack(
    val id: Int,
    val cover: String,
    val name: String,
    val description: String,
    val genre: String,
    val recordLabel: String,
    val releaseDate: String,
    val tracks: List<Track>
)