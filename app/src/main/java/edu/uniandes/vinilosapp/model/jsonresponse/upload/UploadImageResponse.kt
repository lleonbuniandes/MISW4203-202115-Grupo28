package edu.uniandes.vinilosapp.model.jsonresponse.upload

data class UploadImageResponse(
    val `data`: Data,
    val status: Int,
    val success: Boolean
)