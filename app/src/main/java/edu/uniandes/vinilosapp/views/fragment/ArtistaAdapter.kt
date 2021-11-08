package edu.uniandes.vinilosapp.views.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import edu.uniandes.vinilosapp.R
import edu.uniandes.vinilosapp.databinding.ArtistaItemBinding
import edu.uniandes.vinilosapp.databinding.FragmentArtistasBinding
import edu.uniandes.vinilosapp.models.ArtistaModel

class ArtistaAdapter : RecyclerView.Adapter<ArtistaAdapter.ArtistaViewHolder>() {
    var artistas: List<ArtistaModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ArtistaViewHolder(val viewDataBinding: ArtistaItemBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {
        companion object {
            @LayoutRes
            val LAYOUT = R.layout.artista_item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistaViewHolder {
        val withDataBinding: ArtistaItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            ArtistaViewHolder.LAYOUT,
            parent,
            false
        )
        return ArtistaViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: ArtistaViewHolder, position: Int) {
        holder.viewDataBinding.also {
            val artista: ArtistaModel = artistas[position]
            Picasso.get().load(artista.imagen).placeholder(R.drawable.icon)
                .error(R.drawable.icon)
                .into(it.ivImagenArtista)

            it.artista = artista
        }
    }

    override fun getItemCount(): Int {
        return artistas.size
    }
}