package edu.uniandes.vinilosapp.view.track

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import edu.uniandes.vinilosapp.adapter.AlbumAdapter
import edu.uniandes.vinilosapp.databinding.ActivityTrackListBinding
import edu.uniandes.vinilosapp.viewmodel.AlbumViewModel

class TrackList : AppCompatActivity() {

    companion object{
        const val ALBUM_TRACK_KEY="album_key"
    }

    private lateinit var binding: ActivityTrackListBinding
    private val viewModel:AlbumViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTrackListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listTrack.layoutManager = LinearLayoutManager(this)
        val adapter = AlbumAdapter()
        binding.listTrack.adapter = adapter
    }
}