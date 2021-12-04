package edu.uniandes.vinilosapp.view.album

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import edu.uniandes.vinilosapp.databinding.ActivityAddAlbumBinding
import edu.uniandes.vinilosapp.model.jsonrequest.AlbumRequest
import edu.uniandes.vinilosapp.util.CommonUtil
import edu.uniandes.vinilosapp.util.DatePicker
import edu.uniandes.vinilosapp.viewmodel.AlbumViewModel


class AddAlbum : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: ActivityAddAlbumBinding
    private val viewModel: AlbumViewModel by viewModels()

    private lateinit var record: ArrayAdapter<String>
    private lateinit var genero: ArrayAdapter<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddAlbumBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fillSpinner()

        binding.txtFechaAlbum.setOnClickListener {
            seleccionarFecha()
        }

        val loadImg =
            registerForActivityResult(ActivityResultContracts.GetContent(), ActivityResultCallback {
                binding.imgImageCover.setImageURI(it)
            })

        binding.btnSubirImagen.setOnClickListener {
            loadImg.launch("image/*")
        }

        viewModel.status.observe(this,{
            status->
            if(status.id != null ) {
                finish()
            }else{
                Toast.makeText(this,"No se pudo guardar", Toast.LENGTH_SHORT).show()
            }
        })

        addNewAlbum()
    }

    private fun addNewAlbum() {
        binding.btnSaveAlbum.setOnClickListener {
            val album = AlbumRequest(
                binding.txtNombreAlbum.text.toString(),
                binding.txtDescripcionAlbum.text.toString(),
                CommonUtil.DEFAULT_IMG,
                binding.txtGeneroAlbum.selectedItem.toString(),
                binding.txtRecordAlbum.selectedItem.toString(),
                binding.txtFechaAlbum.text.toString()
            )
            viewModel.createAlbum(album)
            Toast.makeText(this, "Se creó nuevo álbum", Toast.LENGTH_LONG).show()
            val intent = Intent(this, AlbumList::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun fillSpinner() {
        record = ArrayAdapter<String>(this, R.layout.simple_spinner_dropdown_item)
        record.addAll(CommonUtil.LABEL)
        binding.txtRecordAlbum.onItemSelectedListener = this
        binding.txtRecordAlbum.adapter = record

        genero = ArrayAdapter<String>(this, R.layout.simple_spinner_dropdown_item)
        genero.addAll(CommonUtil.GENERES)
        binding.txtGeneroAlbum.onItemSelectedListener =this
        binding.txtGeneroAlbum.adapter = genero
    }

    private fun seleccionarFecha() {
        val datePicker = DatePicker { day, month, year -> onSelectDate(day, month, year) }
        datePicker.show(supportFragmentManager, "")
    }

    private fun onSelectDate(day: Int, month: Int, year: Int) {
        binding.txtFechaAlbum.setText("$year-$month-$day")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

}