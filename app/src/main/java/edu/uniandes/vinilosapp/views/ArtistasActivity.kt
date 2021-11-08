package edu.uniandes.vinilosapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.uniandes.vinilosapp.R
import edu.uniandes.vinilosapp.databinding.ActivityArtistasBinding

import android.view.ViewGroup

import android.view.LayoutInflater
import android.view.View


class ArtistasActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArtistasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MyToolbar().show(this, "Artistas", true)

        binding = ActivityArtistasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

    }

    fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_artistas, container, false)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}