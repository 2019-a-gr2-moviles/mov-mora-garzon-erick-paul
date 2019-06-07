package com.example.a03_android

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recicler_view.*

class ReciclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recicler_view)

        val recycler_view = rv_personas
        val actividad = this

        val lista = arrayListOf<Persona>()
        lista.add(Persona("Erick","1545215645"))
        lista.add(Persona("Paul","1754858566"))
        lista.add(Persona("Paul","1846868686"))

        val adaptadorPersona = AdaptadorPersona(lista,actividad,recycler_view)

        rv_personas.adapter = adaptadorPersona
        rv_personas.itemAnimator = DefaultItemAnimator()
        rv_personas.layoutManager = LinearLayoutManager(this)

        adaptadorPersona.notifyDataSetChanged()

    }


}
