package com.example.examen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lista_peliculas.*

class ListaPeliculas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_peliculas)

        val pelicula:Pelicula = this.intent.
            getParcelableExtra<Pelicula>("pelicula")
        val listaDePeliculas = arrayListOf<Pelicula>()
        listaDePeliculas.add(0,pelicula)
        Log.i("parcelable","Nombre ${pelicula?.nombre}")

        val adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            listaDePeliculas)

        lvPeliculas.adapter = adapter
    }
}

