package edu.uniandes.vinilosapp.view.album

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import edu.uniandes.vinilosapp.R
import edu.uniandes.vinilosapp.databinding.ActivityAlbumDetailItemBinding
import edu.uniandes.vinilosapp.model.Album
import edu.uniandes.vinilosapp.util.CommonUtil

class AlbumDetailItem : AppCompatActivity() {

    companion object{
        const val ALBUM_KEY = "album_list"
    }

    private lateinit var binding: ActivityAlbumDetailItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumDetailItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val album = intent?.extras?.getParcelable<Album>(ALBUM_KEY)!!
        Glide.with(binding.root.context).asBitmap().apply(CommonUtil.myOptions).load(album.cover).into(binding.imageView)
        binding.nombreBanda.text = album.name
        binding.anioCreacion.text = album.releaseDate
        binding.albumGenero.text = album.genre
        binding.textView3.text = album.description
    }
}