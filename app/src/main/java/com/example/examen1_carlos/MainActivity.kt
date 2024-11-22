package com.example.examen1_carlos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imagenButtonNoticas = findViewById<ImageButton>(R.id.imageButtonNoticias)

        imagenButtonNoticas.setOnClickListener {
            val intentInicioNoticias = Intent(application, Noticas:: class.java)
            startActivity(intentInicioNoticias)
        }
    }
}