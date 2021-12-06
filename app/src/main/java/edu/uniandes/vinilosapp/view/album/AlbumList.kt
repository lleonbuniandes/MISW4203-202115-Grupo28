package edu.uniandes.vinilosapp.view.album

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import edu.uniandes.vinilosapp.adapter.AlbumAdapter
import edu.uniandes.vinilosapp.databinding.ActivityAlbumListBinding
import edu.uniandes.vinilosapp.model.Album
import edu.uniandes.vinilosapp.viewmodel.AlbumViewModel

class AlbumList : AppCompatActivity() {

    private lateinit var binding: ActivityAlbumListBinding
    private val viewModel: AlbumViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.albumListRecycler.layoutManager = LinearLayoutManager(this)

        //val viewModel = ViewModelProvider(this,ViewModelFactory(application)).get(AlbumViewModel::class.java)

        val adapter = AlbumAdapter()
        binding.albumListRecycler.adapter = adapter

        viewModel.albumList.observe(this,{
            listAlbum ->
            adapter.submitList(listAlbum)
        })

        adapter.setOnItemClickListener {
            openDetailAlbum(it)
        }

        binding.fabAdd.setOnClickListener {

            viewModel.track.observe(this,{
                Log.i("############",  it.tracks[0].name)
            })
            val intent = Intent(this,AddAlbum::class.java)
            startActivity(intent)
            finish()
        }


    }

    private fun openDetailAlbum(album: Album) {
        val intent = Intent(this, AlbumDetailItem::class.java)
        intent.putExtra(AlbumDetailItem.ALBUM_KEY,album)
        startActivity(intent)
    }


}