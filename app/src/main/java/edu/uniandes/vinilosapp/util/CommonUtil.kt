package edu.uniandes.vinilosapp.util

import android.os.Build
import androidx.annotation.RequiresApi
import com.bumptech.glide.request.RequestOptions
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CommonUtil {
    companion object {
        val myOptions = RequestOptions().override(800, 600).centerCrop().fitCenter()
    }
}