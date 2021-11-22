package edu.uniandes.vinilosapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "tblArtista")
@Parcelize
data class Artista(
    @PrimaryKey
    val id: Int,
    val name: String,
    val image: String,
    val birthDate: String,
    val albums: Int,
    val description: String,
) : Parcelable