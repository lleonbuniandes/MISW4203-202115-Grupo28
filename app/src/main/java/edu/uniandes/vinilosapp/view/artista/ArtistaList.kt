package edu.uniandes.vinilosapp.view.artista

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import edu.uniandes.vinilosapp.adapter.ArtistaAdapter
import edu.uniandes.vinilosapp.databinding.ActivityArtistaListBinding
import edu.uniandes.vinilosapp.model.Artista
import edu.uniandes.vinilosapp.util.ViewModelFactory
import edu.uniandes.vinilosapp.viewmodel.ArtistaViewModel

class ArtistaList : AppCompatActivity() {

    private lateinit var binding: ActivityArtistaListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtistaListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.artistaListRecycler.layoutManager = LinearLayoutManager(this)

        val viewModel = ViewModelProvider(this, ViewModelFactory(application)).get(ArtistaViewModel::class.java)

        val adapter = ArtistaAdapter()
        binding.artistaListRecycler.adapter = adapter

        viewModel.artistaList.observe(this, { listArtista ->
            adapter.submitList(listArtista)
        })

        adapter.setOnItemClickListener {
            openDetailArtista(it)
        }
    }

    private fun openDetailArtista(artista: Artista) {
        val intent = Intent(this,ArtistaDetailItem::class.java)
        intent.putExtra(ArtistaDetailItem.ARTIST_KEY,artista)
        startActivity(intent)
    }

}