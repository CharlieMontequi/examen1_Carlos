package com.example.examen1_carlos

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// se implementa la clase abstraca de adapterview para poder modificar el adaptador
class Noticas : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private val titularesNoticias = arrayOf(
        "Todas las noticias",
        "noticia de politica",
        "noticia de deporte",
        "noticia de Economía",
        "noticia de cultura"
    )
    private val tiposNoticias = arrayOf("Política", "Deportes", "Economía", "Cultura")
    private val iconosNoticias = intArrayOf(
        R.drawable.cyltv,
        R.drawable.ic_politics,
        R.drawable.ic_sports,
        R.drawable.ic_economy,
        R.drawable.ic_culture
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.noticas_layout)

        // se establecen lso widget que se van a usar
        val spinnerFiltro = findViewById<Spinner>(R.id.spinnerFiltrante)

        // como se crea una vista personalizada se necesita un adaptador igual que se acomode a los elementos de la vista
        val adaptadorPersonalizado = AdaptadorPersonalizado(this, R.layout.lineas_spinner_personal, tiposNoticias)
        spinnerFiltro.adapter = adaptadorPersonalizado
        spinnerFiltro.onItemSelectedListener = this

        val listViewNoticias = findViewById<ListView>(R.id.listViewNoticias)
        // como el list no se modifica se puede usar el layout propio de android
        val adaptadorList = ArrayAdapter(this, android.R.layout.simple_list_item_1, titularesNoticias)
        listViewNoticias.adapter =adaptadorList

        listViewNoticias.setOnClickListener {

            val intentDetallesNoticias = Intent(application, Detalles_noticias:: class.java)
            intentDetallesNoticias.putExtra("noticias", listViewNoticias.isSelected.toString())

            startActivity(intentDetallesNoticias)
        }



    }

    private inner class AdaptadorPersonalizado(
        context: Context,// contexto que es la main
        resource: Int, // el id de la vista que se va a usar
        objects: Array<String>
    ) // el array de datos que se va a mostrar y que sera referente a la posicion para el resto
        : ArrayAdapter<String>(context, resource, objects) {

        override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {

            return lineasSpinnerPersonal(position, convertView, parent)
        }

        private fun lineasSpinnerPersonal(
            position: Int,
            convertView: View?,
            parent: ViewGroup
        ): View {

            //se crea un inflador que infla la vista y permite verla
            val layoutInflater = LayoutInflater.from(context)// el contexto es de la clase interna

            //se declara la vista anclandola a la creca, se estipula donde se va a mostrar que es en la padre y se indica si se ciñe a las caracteristicas del mismo(en esete caso no)
            val rowView = convertView ?: layoutInflater.inflate(
                R.layout.lineas_spinner_personal,
                parent,
                false
            )

            // con la posicion del array se crean todas las demas filas
            rowView.findViewById<TextView>(R.id.textViewTipoNoticia).text = tiposNoticias[position]
            rowView.findViewById<ImageView>(R.id.imageViewIcono).setImageResource(iconosNoticias[position])

            // devuelve la fila creada con los datos
            return rowView
        }
        override fun getView(
            position: Int,
            convertView: View?,
            parent: ViewGroup
        ): View {
            // Este método se llama para mostrar una vista personalizada en el elemento seleccionado

            // Llama a la función para crear la fila personalizada y la devuelve
            return lineasSpinnerPersonal(position, convertView, parent)
        }

    }


    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {


    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}