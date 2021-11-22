package edu.uniandes.vinilosapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.uniandes.vinilosapp.R
import edu.uniandes.vinilosapp.databinding.ArtistaListItemBinding
import edu.uniandes.vinilosapp.model.Artista
import edu.uniandes.vinilosapp.util.CommonUtil


private val TAG = ArtistaAdapter::class.simpleName
class ArtistaAdapter: ListAdapter<Artista, ArtistaAdapter.ArtistaViewHolder>(DiffCallback) {

    lateinit var onItemClickLister:(Artista) -> Unit

    companion object DiffCallback : DiffUtil.ItemCallback<Artista>() {
        override fun areItemsTheSame(oldItem: Artista, newItem: Artista): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Artista, newItem: Artista): Boolean {
            return oldItem == newItem
        }
    }

    fun setOnItemClickListener(onItemClickListener: (artista: Artista) -> Unit) {
        this.onItemClickLister = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistaAdapter.ArtistaViewHolder {
        val binding = ArtistaListItemBinding.inflate(LayoutInflater.from(parent.context))
        return ArtistaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArtistaAdapter.ArtistaViewHolder, position: Int) {
        val artista = getItem(position)
        holder.bind(artista)
    }

    inner class ArtistaViewHolder(private val binding: ArtistaListItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(artista: Artista) {
            binding.nombreArtista.text = artista.name
            binding.fechaNacimiento.text = artista.birthDate
            binding.numeroAlbums.text = artista.albums.toString()
            val urlImage = artista.image
            Glide.with(binding.root.context).asBitmap().apply(CommonUtil.myOptions).placeholder(R.drawable.music_default_image).error(
                R.drawable.music_default_image).load(urlImage).circleCrop().into(binding.artistaImage)

            binding.root.setOnClickListener {
                if(::onItemClickLister.isInitialized){
                    onItemClickLister(artista)
                }else {
                    Log.e(TAG,"ERROR al seleccionar un item")
                }
            }

        }

    }

}