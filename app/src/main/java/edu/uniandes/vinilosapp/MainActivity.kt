package edu.uniandes.vinilosapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.uniandes.vinilosapp.databinding.ActivityMainBinding
import edu.uniandes.vinilosapp.view.ColeccionistaActivity
import edu.uniandes.vinilosapp.view.InvitadoActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMainColeccionista.setOnClickListener {
            val intent = Intent(this, ColeccionistaActivity::class.java)
            startActivity(intent)
        }
        binding.btnMainInvitado.setOnClickListener {
            val intent = Intent(this, InvitadoActivity::class.java)
            startActivity(intent)
        }
    }


}