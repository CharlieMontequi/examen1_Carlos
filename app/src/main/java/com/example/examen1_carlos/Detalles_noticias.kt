package com.example.examen1_carlos

import android.content.Intent
import android.os.Bundle
import android.widget.AutoCompleteTextView.Validator
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Detalles_noticias: AppCompatActivity() {

    private lateinit var textViewTitulo : TextView
    private lateinit var  textViewNoticia : TextView
    // se crean las claves para poder guardar y recueprar los datos antes los reinicios de al actividad
    private val CLAVE_TEXTVIEWTITULO = "clave titulo"
    private val CLAVE_TEXTVIEWNOTICIA = "clave noticia"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalles_noticas)

        // comprobar si se hay algo guardado con anterioridad para cargarlo
        if(savedInstanceState!=null){
            val titloGuardado = savedInstanceState.getString(CLAVE_TEXTVIEWTITULO)
            val noticiaGuardada = savedInstanceState.getString(CLAVE_TEXTVIEWNOTICIA)
            textViewTitulo.text= titloGuardado
            textViewNoticia.text=noticiaGuardada
        }
         val intent = Intent()

        val auxiliarNombre = getIntent().getStringExtra("noticias")
        textViewTitulo.text= auxiliarNombre

        textViewNoticia.text=getString(R.string.cultura)


        val buttonCompartir = findViewById<Button>(R.id.buttonCompartir)

        buttonCompartir.setOnClickListener {
            //intent de compartir

        }

    }

    // permite guardar los textos de los textviews al reinicar la actividad
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(CLAVE_TEXTVIEWTITULO, textViewTitulo.text.toString())
        outState.putString(CLAVE_TEXTVIEWNOTICIA, textViewNoticia.text.toString())
    }
}