package com.example.examen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lista_actores.*

class ListaActores : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_actores)

        val actor:Actor? = this.intent.
            getParcelableExtra<Actor>("actor")
        val listaDeActores = arrayListOf<Actor?>()
        listaDeActores.add(actor)

        val adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            listaDeActores)

        lvActores.adapter = adapter
    }
}