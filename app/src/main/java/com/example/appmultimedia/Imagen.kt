package com.example.appmultimedia

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appmultimedia.databinding.ActivityMainBinding
import com.example.appmultimedia.databinding.ImagenBinding

class Imagen : AppCompatActivity() {

    private lateinit var binding: ImagenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ImagenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonimagen2.setOnClickListener { seleccionarImagen()}
    }
    val register=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it.resultCode == Activity.RESULT_OK){
            val intent = it.data
            binding.aqui.setImageURI(intent?.data)
        }
    }
    private fun seleccionarImagen(){
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type="image/*"
        register.launch(intent)
    }
}