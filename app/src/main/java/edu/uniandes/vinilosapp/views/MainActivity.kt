package edu.uniandes.vinilosapp.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.uniandes.vinilosapp.R
import edu.uniandes.vinilosapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn01Coleccionista.setOnClickListener {
            val intent = Intent(this, ColeccionistaActivity::class.java)
            startActivity(intent)
        }

        binding.btn02Usuario.setOnClickListener {
            val intent = Intent(this, UsuarioActivity::class.java)
            startActivity(intent)
        }
    }



}