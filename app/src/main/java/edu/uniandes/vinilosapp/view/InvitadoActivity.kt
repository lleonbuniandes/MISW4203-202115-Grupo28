package edu.uniandes.vinilosapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.uniandes.vinilosapp.databinding.ActivityInvitadoBinding
import edu.uniandes.vinilosapp.view.album.AlbumList
import edu.uniandes.vinilosapp.view.artista.ArtistaList

class InvitadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityInvitadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInvitadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnInvitAlbum.setOnClickListener {
            val intent = Intent(this,AlbumList::class.java)
            startActivity(intent)
        }

        binding.btnInvitArtista.setOnClickListener {
            val intent = Intent(this,ArtistaList::class.java)
            startActivity(intent)
        }
    }
}