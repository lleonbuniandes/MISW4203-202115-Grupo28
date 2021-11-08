package edu.uniandes.vinilosapp.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.uniandes.vinilosapp.R
import edu.uniandes.vinilosapp.databinding.ActivityColeccionistaBinding

class ColeccionistaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityColeccionistaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coleccionista)
        MyToolbar().show(this, "Coleccionista", true)


        binding = ActivityColeccionistaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn03OpcionesAlbum.setOnClickListener {
            val intent = Intent(this, OpcionesAlbumActivity::class.java)
            startActivity(intent)
        }
        binding.btn04Artistas.setOnClickListener {
            val intent = Intent(this, ArtistasActivity::class.java)
            startActivity(intent)
        }


    }


}