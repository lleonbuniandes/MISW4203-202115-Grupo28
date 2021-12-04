package edu.uniandes.vinilosapp.view.artista

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import edu.uniandes.vinilosapp.adapter.ColeccionistaAdapter
import edu.uniandes.vinilosapp.databinding.ActivityColeccionistaListBinding
import edu.uniandes.vinilosapp.viewmodel.ColeccionistaViewModel

class ColeccionistaList : AppCompatActivity() {

    private lateinit var binding: ActivityColeccionistaListBinding

    private val viewModel:ColeccionistaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityColeccionistaListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.coleccionistaListRecycler.layoutManager = LinearLayoutManager(this)

        val adapter = ColeccionistaAdapter()
        binding.coleccionistaListRecycler.adapter = adapter

        viewModel.coleccionistaList.observe(this, {listCollector ->
            adapter.submitList(listCollector)
        })

    }
}