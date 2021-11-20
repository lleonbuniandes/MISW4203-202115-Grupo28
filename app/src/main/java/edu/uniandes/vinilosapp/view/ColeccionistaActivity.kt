package edu.uniandes.vinilosapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.uniandes.vinilosapp.databinding.ActivityColeccionistaBinding

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
    }
}