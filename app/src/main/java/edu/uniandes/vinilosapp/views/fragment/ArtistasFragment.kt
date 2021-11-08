package edu.uniandes.vinilosapp.views.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.uniandes.vinilosapp.R
import edu.uniandes.vinilosapp.databinding.FragmentArtistasBinding
import edu.uniandes.vinilosapp.view_models.ArtistaViewModel

class ArtistasFragment : Fragment() {
    private var _binding: FragmentArtistasBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: ArtistaViewModel
    private var viewModelAdapter: ArtistaAdapter? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArtistasBinding.inflate(inflater, container, false)
        viewModelAdapter = ArtistaAdapter()

        val activity = requireNotNull(this.activity)

        viewModel = ViewModelProvider(this,
            ArtistaViewModel.Factory(activity.application)).get(ArtistaViewModel::class.java)

        viewModel.artistas.observe(viewLifecycleOwner, {
            it.apply {
                viewModelAdapter!!.artistas = this
            }
        })

        viewModel.eventNetworkError.observe(viewLifecycleOwner, { isNetworkError ->
            if (isNetworkError) onNetworkError()
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.rvArtista
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.adapter = viewModelAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onNetworkError() {
        if(!viewModel.isNetworkErrorShown.value!!) {
            Toast.makeText(activity, "Network Error", Toast.LENGTH_LONG).show()
            viewModel.onNetworkErrorShown()
        }
    }
}