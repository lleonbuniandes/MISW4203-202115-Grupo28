package edu.uniandes.vinilosapp.util

import com.bumptech.glide.request.RequestOptions

class CommonUtil {
    companion object {
        val myOptions = RequestOptions().override(400, 400).centerCrop().fitCenter()
    }
}