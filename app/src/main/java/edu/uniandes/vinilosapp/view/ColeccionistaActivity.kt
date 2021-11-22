package edu.uniandes.vinilosapp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.uniandes.vinilosapp.databinding.ActivityColeccionistaBinding
import edu.uniandes.vinilosapp.view.artista.ArtistaList
import edu.uniandes.vinilosapp.view.artista.ColeccionistaList

class ColeccionistaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityColeccionistaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityColeccionistaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOptAlbum.setOnClickListener {
            val intent = Intent(this, AlbumOptionActivity::class.java)
            startActivity(intent)
        }

        binding.btnCollectorArtista.setOnClickListener {
            val intent = Intent(this, ArtistaList::class.java)
            startActivity(intent)
        }

        binding.btnCollectorColeccionista.setOnClickListener {
            val intent = Intent(this, ColeccionistaList::class.java)
            startActivity(intent)
        }
    }
}