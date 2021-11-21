package edu.uniandes.vinilosapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.uniandes.vinilosapp.R
import edu.uniandes.vinilosapp.databinding.AlbumListItemBinding
import edu.uniandes.vinilosapp.model.Album
import edu.uniandes.vinilosapp.util.CommonUtil


private val TAG = AlbumAdapter::class.simpleName
class AlbumAdapter: ListAdapter<Album, AlbumAdapter.AlbumViewHolder>(DiffCallback) {

    lateinit var onItemClickLister:(Album) -> Unit

    companion object DiffCallback : DiffUtil.ItemCallback<Album>() {
        override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
            return oldItem == newItem
        }
    }


    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): AlbumAdapter.AlbumViewHolder {
        val binding = AlbumListItemBinding.inflate(LayoutInflater.from(parent.context))
        return AlbumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumAdapter.AlbumViewHolder, position: Int) {
        val album = getItem(position)
        holder.bind(album)
    }

    fun setOnItemClickListener(onItemClickListener: (album: Album) -> Unit) {
        this.onItemClickLister = onItemClickListener
    }

    inner class AlbumViewHolder(private val binding: AlbumListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(album:Album) {
            binding.nombreBanda.text = album.name
            binding.anioCreacion.text = album.releaseDate
            val urlImage = album.cover
            Glide.with(binding.root.context).asBitmap().apply(CommonUtil.myOptions).placeholder(R.drawable.music_default_image).error(R.drawable.music_default_image).load(urlImage).circleCrop().into(binding.albumImage)
            binding.albumGenero.text = album.genre

            binding.root.setOnClickListener {
                if(::onItemClickLister.isInitialized){
                    onItemClickLister(album)
                }else {
                    Log.e(TAG,"ERROR al seleccionar un item")
                }
            }
        }
    }

}