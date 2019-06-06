package com.example.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_crear_pelicula.*

class CrearPelicula : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_pelicula)
        btnGuardar.setOnClickListener {
            crearPelicula()
        }
    }

    fun crearPelicula(){
        val intentExplicito = Intent(
            this,
            ListaPeliculas::class.java
        )

        var identificadorPelicula = Integer.parseInt(tBIdPel.text.toString())
        var nombre = tBNombre.text.toString()
        var anioLanzamiento = Integer.parseInt(tBAnio.text.toString())
        var rating = Integer.parseInt(tbRating.text.toString())
        var actoresPrincipales = tBActoresP.text.toString()
        var sinopsis = tBSinopsis.text.toString()
        var actorId = Integer.parseInt(tBIdActor.text.toString())

        val pelicula = Pelicula(identificadorPelicula,nombre,anioLanzamiento,rating,actoresPrincipales,sinopsis,actorId)

        intentExplicito.putExtra("pelicula",pelicula)

    }
}