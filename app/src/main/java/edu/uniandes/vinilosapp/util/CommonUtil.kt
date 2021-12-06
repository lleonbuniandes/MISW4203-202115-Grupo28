package edu.uniandes.vinilosapp.util

import com.bumptech.glide.request.RequestOptions
import java.util.*

class CommonUtil {
    companion object {
        val myOptions = RequestOptions().override(400, 400).centerCrop().fitCenter()
        var DEFAULT_IMG = "https://i.imgur.com/Yu8Qv8J.jpeg"
        val GENERES = Arrays.asList("Classical", "Salsa", "Rock","Folk")
        val LABEL =  Arrays.asList("Sony Music", "EMI", "Discos Fuentes","Elektra","Fania Records")
    }
}