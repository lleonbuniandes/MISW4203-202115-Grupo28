package edu.uniandes.vinilosapp.model.jsonresponse

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class AlbumCollectorResponse(
    val id: Int?,
    val name: String?,
    val image: String?,
    val description: String?,
    val birthDate:String?
) : Parcelable