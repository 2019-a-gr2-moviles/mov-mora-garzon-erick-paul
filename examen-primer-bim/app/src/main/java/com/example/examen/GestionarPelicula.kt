package com.example.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_pelicula.*

class GestionarPelicula : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pelicula)

        var pelicula: Pelicula = this.intent.getParcelableExtra<Pelicula>("pelicula")
        insertarPelicula(pelicula)
        btnEliminar.setOnClickListener {

            irAListaPeliculas(pelicula)
        }


        btnActualizar.setOnClickListener {
            val pelicula2 = Pelicula(

                Integer.parseInt(tBIdPel.text.toString()),
                tBNombre.text.toString(),
                Integer.parseInt(tBAnio.text.toString()),
                Integer.parseInt(tbRating.text.toString()),
                tBActores.text.toString(),
                tBSinopsis.text.toString(),
                Integer.parseInt(tBIdActor.text.toString())

            )
            irAListaPeliculas(pelicula2)
        }
    }


    private fun insertarPelicula(pelicula: Pelicula) {
        tBIdPel.setText(pelicula.identificadorPelicula.toString())
        tBNombre.setText(pelicula.nombre)
        tBAnio.setText(pelicula.anioLanzamiento.toString())
        tbRating.setText(pelicula.rating)
        tBActores.setText(pelicula.actoresPrincipales)
        tBSinopsis.setText(pelicula.sinopsis)
        tBIdActor.setText(pelicula.actorId.toString())

    }

    private fun irAListaPeliculas(pelicula: Pelicula) {
        val intent = Intent(
            this,
            ListaPeliculas::class.java
        )
        intent.putExtra("pelicula", pelicula)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}