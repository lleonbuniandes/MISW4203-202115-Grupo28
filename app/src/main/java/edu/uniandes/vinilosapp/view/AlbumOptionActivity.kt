package edu.uniandes.vinilosapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.uniandes.vinilosapp.databinding.ActivityAlbumOptionBinding
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
    }
}