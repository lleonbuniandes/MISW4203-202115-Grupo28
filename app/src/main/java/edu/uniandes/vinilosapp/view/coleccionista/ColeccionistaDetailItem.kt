package edu.uniandes.vinilosapp.view.coleccionista

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.uniandes.vinilosapp.databinding.ActivityColeccionistaDetailItemBinding
import edu.uniandes.vinilosapp.model.Coleccionista

class ColeccionistaDetailItem : AppCompatActivity() {

    companion object {
        const val COLECTOR_KEY = "coleccionsta_key"
    }

    private lateinit var binding: ActivityColeccionistaDetailItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityColeccionistaDetailItemBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val coleccionista = intent?.extras?.getParcelable<Coleccionista>(COLECTOR_KEY)!!
        binding.txtNombre.text = coleccionista.name
        binding.txtEmail.text = coleccionista.email
        binding.txtelefono.text = coleccionista.telephone
        binding.txtfavorito.text = coleccionista.album

    }
}