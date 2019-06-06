package com.example.examen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import kotlinx.android.synthetic.main.activity_principal.*

class Principal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        btn_gestionar_actores.setOnClickListener{
            irAListaActores()
        }

        btn_crear_actores.setOnClickListener {
            irACrearActor()
        }
    }

    fun irAListaActores(){
        val intentExplicito = Intent(
            this,
            ListaActores::class.java
        )

        startActivity(intentExplicito)
    }

    fun irACrearActor(){
        val intentExplicito = Intent(
            this,
            CrearActor::class.java
        )

        startActivity(intentExplicito)
    }
}