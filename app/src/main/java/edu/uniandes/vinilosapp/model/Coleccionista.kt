package edu.uniandes.vinilosapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName="tblColeccionista")
@Parcelize
data class Coleccionista(
    @PrimaryKey
    val id: Int,
    val name: String,
    val email: String,
    val telephone: String,
    val album: String
): Parcelable