package edu.uniandes.vinilosapp.view.album

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.uniandes.vinilosapp.databinding.ActivityAddAlbumBinding
import edu.uniandes.vinilosapp.util.DatePicker

class AddAlbum : AppCompatActivity() {
    private lateinit var binding: ActivityAddAlbumBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddAlbumBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.txtFechaAlbum.setOnClickListener {
            seleccionarFecha()
        }
    }

    private fun seleccionarFecha() {
        val datePicker = DatePicker{ day, month,year -> onSelectDate(day,month,year)}
        datePicker.show(supportFragmentManager,"")
    }

    private fun onSelectDate(day: Int, month: Int, year: Int) {
        binding.txtFechaAlbum.setText("$year-$month-$day")
    }
}