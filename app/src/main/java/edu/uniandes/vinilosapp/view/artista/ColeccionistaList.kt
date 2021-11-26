package edu.uniandes.vinilosapp.view.artista

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import edu.uniandes.vinilosapp.adapter.ColeccionistaAdapter
import edu.uniandes.vinilosapp.databinding.ActivityColeccionistaListBinding
import edu.uniandes.vinilosapp.util.ViewModelFactory
import edu.uniandes.vinilosapp.viewmodel.ColeccionistaViewModel

class ColeccionistaList : AppCompatActivity() {

    private lateinit var binding: ActivityColeccionistaListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityColeccionistaListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.coleccionistaListRecycler.layoutManager = LinearLayoutManager(this)

        val viewModel = ViewModelProvider(this,ViewModelFactory(application)).get(ColeccionistaViewModel::class.java)

        val adapter = ColeccionistaAdapter()
        binding.coleccionistaListRecycler.adapter = adapter

        viewModel.coleccionistaList.observe(this, {listCollector ->
            adapter.submitList(listCollector)
        })

    }
}