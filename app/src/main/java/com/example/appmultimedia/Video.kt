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
import com.example.appmultimedia.databinding.VideoBinding

class Video : AppCompatActivity() {

    private lateinit var binding: VideoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = VideoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonvideo2.setOnClickListener { seleccionarVideo() }
    }

    val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            val intent = it.data
            binding.aquivideo.setVideoURI(intent?.data)
            binding.aquivideo.start()
        }
    }

    private fun seleccionarVideo() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "video/*"
        register.launch(intent)
    }
}