package edu.uniandes.vinilosapp.view.artista

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import edu.uniandes.vinilosapp.R
import edu.uniandes.vinilosapp.adapter.ColeccionistaAdapter
import edu.uniandes.vinilosapp.databinding.ActivityArtistaDetailItemBinding
import edu.uniandes.vinilosapp.model.Artista
import edu.uniandes.vinilosapp.util.CommonUtil
import edu.uniandes.vinilosapp.view.track.TrackList

class ArtistaDetailItem : AppCompatActivity() {

    companion object{
        const val ARTIST_KEY ="artist_key"
    }

    private lateinit var binding: ActivityArtistaDetailItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArtistaDetailItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val artista = intent?.extras?.getParcelable<Artista>(ARTIST_KEY)!!
        Glide.with(binding.root.context).asBitmap().apply(CommonUtil.myOptions).placeholder(R.drawable.artista_default_image).error(
            R.drawable.artista_default_image).load(artista.image).into(binding.imageView)

        binding.nombreArtista.text = artista.name
        binding.anioNacimiento.text = artista.birthDate
        binding.numberAlbums.text = artista.albums.toString()
        binding.descripcionArtista.text = artista.description

        val adapter = ColeccionistaAdapter()
        adapter.setOnItemClickListener {
            openTrackList("578")
        }
    }

    private fun openTrackList(id: String) {
        val intent = Intent(this, TrackList::class.java)
        intent.putExtra(TrackList.ALBUM_TRACK_KEY,id)
        startActivity(intent)
    }
}