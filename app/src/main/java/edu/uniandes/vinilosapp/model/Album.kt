package edu.uniandes.vinilosapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "tblAlbum")
@Parcelize
data class Album(
    @PrimaryKey
    val id: Int,
    val name: String,
    val description: String,
    val cover: String,
    val genre: String,
    val recordLabel: String,
    val releaseDate: String
): Parcelable