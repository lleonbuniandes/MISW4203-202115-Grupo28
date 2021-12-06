package edu.uniandes.vinilosapp.view.album

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import edu.uniandes.vinilosapp.R
import edu.uniandes.vinilosapp.databinding.ActivityAlbumDetailItemBinding
import edu.uniandes.vinilosapp.model.Album
import edu.uniandes.vinilosapp.util.CommonUtil
import edu.uniandes.vinilosapp.view.track.TrackList

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
        Glide.with(binding.root.context).asBitmap().apply(CommonUtil.myOptions).placeholder(R.drawable.music_default_image).error(R.drawable.music_default_image).load(album.cover).into(binding.imageView)
        binding.nombreBanda.text = album.name
        binding.anioCreacion.text = album.releaseDate
        binding.albumGenero.text = album.genre
        binding.textView3.text = album.description



        binding.btnViewCancion.setOnClickListener {
            openTrackList("578")
        }
    }
    private fun openTrackList(id: String) {
        val intent = Intent(this, TrackList::class.java)
        intent.putExtra(TrackList.ALBUM_TRACK_KEY,id)
        startActivity(intent)
    }
}