package edu.uniandes.vinilosapp.view.album

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import edu.uniandes.vinilosapp.adapter.AlbumAdapter
import edu.uniandes.vinilosapp.databinding.ActivityAlbumListBinding
import edu.uniandes.vinilosapp.model.Album
import edu.uniandes.vinilosapp.util.ViewModelFactory
import edu.uniandes.vinilosapp.viewmodel.AlbumViewModel

class AlbumList : AppCompatActivity() {

    private lateinit var binding: ActivityAlbumListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlbumListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.albumListRecycler.layoutManager = LinearLayoutManager(this)

        val viewModel = ViewModelProvider(this,ViewModelFactory(application)).get(AlbumViewModel::class.java)

        val adapter = AlbumAdapter()
        binding.albumListRecycler.adapter = adapter

        viewModel.albumList.observe(this,{
            listAlbum ->
            adapter.submitList(listAlbum)
        })

        adapter.setOnItemClickListener {
            openDetailAlbum(it)
        }
    }

    private fun openDetailAlbum(album: Album) {
        val intent = Intent(this, AlbumDetailItem::class.java)
        intent.putExtra(AlbumDetailItem.ALBUM_KEY,album)
        startActivity(intent)
    }
}