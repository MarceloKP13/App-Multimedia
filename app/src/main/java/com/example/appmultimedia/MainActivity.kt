package com.example.appmultimedia

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appmultimedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonimagen.setOnClickListener { irImagen() }
        binding.botonvideo.setOnClickListener { irVideo() }
        }

    private fun irImagen(){
        val intent = Intent(this,Imagen::class.java)
        startActivity(intent)
    }

    private fun irVideo(){
        val intent = Intent(this,Video::class.java)
        startActivity(intent)
    }
}