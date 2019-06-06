package com.example.examen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import kotlinx.android.synthetic.main.activity_crear_actor.tBNombre
import kotlinx.android.synthetic.main.activity_crear_actor.tBFechaNac
import kotlinx.android.synthetic.main.activity_crear_actor.tBNumPel
import kotlinx.android.synthetic.main.activity_crear_actor.cBRetirado
import kotlinx.android.synthetic.main.activity_crear_actor.*
import java.util.*


class CrearActor : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_actor)

        btnGuardar.setOnClickListener {
            crearActor()
        }
    }

    fun crearActor(){
        val intentExplicito = Intent(
            this,
            ListaActores::class.java
        )

        val nombre = tBNombre.text.toString()
        val apellido = tBApellido.text.toString()
        var fechaNacimiento = Date(tBFechaNac.text.toString())
        var numeroPeliculas = Integer.parseInt(tBNumPel.text.toString())
        var retirado = false
        if (cBRetirado.isChecked)
            retirado = true

        val actor = Actor(nombre,apellido,fechaNacimiento,numeroPeliculas,retirado)

        intentExplicito.putExtra("actor",actor)


    }
}