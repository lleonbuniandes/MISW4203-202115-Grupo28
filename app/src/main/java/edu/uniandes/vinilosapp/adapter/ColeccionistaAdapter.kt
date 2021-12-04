package edu.uniandes.vinilosapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.uniandes.vinilosapp.R
import edu.uniandes.vinilosapp.databinding.ColeccionistaListItemBinding
import edu.uniandes.vinilosapp.model.Coleccionista
import edu.uniandes.vinilosapp.util.CommonUtil

private val TAG = ColeccionistaAdapter::class.simpleName
class ColeccionistaAdapter: ListAdapter<Coleccionista, ColeccionistaAdapter.ColeccionistaViewHolder>(DiffCallback) {

    lateinit var onItemClickLister:(Coleccionista) -> Unit

    companion object DiffCallback : DiffUtil.ItemCallback<Coleccionista>() {
        override fun areItemsTheSame(oldItem: Coleccionista, newItem: Coleccionista): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Coleccionista, newItem: Coleccionista): Boolean {
            return oldItem == newItem
        }
    }

    fun setOnItemClickListener(onItemClickListener: (coleccionista: Coleccionista) -> Unit) {
        this.onItemClickLister = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColeccionistaAdapter.ColeccionistaViewHolder {
        val binding = ColeccionistaListItemBinding.inflate(LayoutInflater.from(parent.context))
        return ColeccionistaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ColeccionistaAdapter.ColeccionistaViewHolder, position: Int) {
        val collector = getItem(position)
        holder.bind(collector)
    }

    inner class ColeccionistaViewHolder(private val binding: ColeccionistaListItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(collector: Coleccionista) {
            binding.nombre.text = collector.name
            binding.email.text = collector.email
            binding.telefono.text = collector.telephone
            Glide.with(binding.root.context).asBitmap().apply(CommonUtil.myOptions).placeholder(R.drawable.user_default_image).error(
                R.drawable.user_default_image).load(R.drawable.user_default_image).circleCrop().into(binding.usuarioImage)

            binding.root.setOnClickListener {
                if(::onItemClickLister.isInitialized){
                    onItemClickLister(collector)
                }else {
                    Log.e(TAG,"ERROR al seleccionar un item")
                }
            }
        }
    }
}