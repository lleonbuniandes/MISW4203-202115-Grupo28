package edu.uniandes.vinilosapp.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.uniandes.vinilosapp.databinding.ActivityAlbumOptionBinding
import edu.uniandes.vinilosapp.view.album.AddAlbum
import edu.uniandes.vinilosapp.view.album.AlbumList

class AlbumOptionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlbumOptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumOptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOptListado.setOnClickListener {
            val intent = Intent(this, AlbumList::class.java)
            startActivity(intent)
        }

        binding.btnOptAgregarAlbum.setOnClickListener {
            val intent = Intent(this, AddAlbum::class.java)
            startActivity(intent)
        }
        binding.btnOptLinkTrack.setOnClickListener {
            val intent = Intent(this, AlbumList::class.java)
            startActivity(intent)
            Toast.makeText(applicationContext,"Seleccione un Albúm",Toast.LENGTH_LONG)
        }

    }
}