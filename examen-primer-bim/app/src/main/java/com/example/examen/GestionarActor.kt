package com.example.examen

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_actor.*
import java.util.*

class GestionarActor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actor)

        var actor: Actor = this.intent.getParcelableExtra<Actor>("actor")
        insertarActor(actor)
        btnEliminar.setOnClickListener {

            irAListaActores(actor)
        }
        btnGestionarPel.setOnClickListener {
            irAListaPeliculas(actor)
        }

        btnCrearPel.setOnClickListener {
            nuevaPelicula(actor)
        }

        btnActualizar.setOnClickListener {
            val actor2 = Actor(

                tBNombre.text.toString(),
                tBApelllido.text.toString(),
                Date(tBFechaNac.text.toString()),
                Integer.parseInt(tBNumPel.text.toString()),
                cBRetirado.isChecked

            )
            irAListaActores(actor2)
        }
    }

    private fun irAListaActores(actor: Actor) {
        val intent = Intent(
            this,
            ListaActores::class.java
        )
        intent.putExtra("actor", actor)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun insertarActor(actor: Actor) {
        tBNombre.setText(actor.nombre)
        tBApelllido.setText(actor.apellido)
        tBFechaNac.setText(actor.fechaNacimiento.toString())
        tBNumPel.setText(actor.numeroPeliculas.toString())
        cBRetirado.isChecked = actor.retirado
    }

    private fun irAListaPeliculas(actor: Actor) {
        val intent = Intent(
            this,
            ListaPeliculas::class.java
        )
        intent.putExtra("actor", actor)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun nuevaPelicula(actor: Actor) {
        val intent = Intent(
            this,
            CrearPelicula::class.java
        )
        intent.putExtra("actor", actor)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}