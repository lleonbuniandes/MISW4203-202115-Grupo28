package edu.uniandes.vinilosapp.model.jsonresponse.collector

import android.os.Parcelable
import edu.uniandes.vinilosapp.model.jsonresponse.album.AlbumCollectorResponse
import kotlinx.android.parcel.Parcelize

@Parcelize
class CollectorResponse(
    val id: Int,
    val name: String,
    val email: String,
    val telephone: String,
    val favoritePerformers: MutableList<AlbumCollectorResponse>
) : Parcelable