package com.example.twitter

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_view.*

class ReciclerView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        val lista = arrayListOf<Tweet>()
        lista.add(
            Tweet(
                1,
                "Alejandro Jodorow",
                "@alejodo",
                "1d",
                "Siente que manipulas lo ligero como si fuera pesado y lo pesado como si fuera ligero. \n\n" +
                        "Cuando deposites un objeto hazlo con la misma delicadeza con que te despides de tu amada.",
                4,
                72,
                370/*,
                "11:36 a.m. - 18 jun 19"*/
            )
        )
        lista.add(
            Tweet(
                2,
                "El Comercio",
                "@elcomercio",
                "7h",
                "Cuatro centros de eduación superior del Ecuador aparecen en el reconocido QS World University Rankings de las mejores universidades del mundo. \n " +
                          "¿Qué institución lidera a escala global?",
                11,
                66,
                37/*,
                "7:33 p.m. - 19 jun 19"*/
            )
        )
        lista.add(
            Tweet(
                3,
                "Sandra Sanchez",
                "@KushiRimay",
                "14 jun",
                "My research paper A Method for Accessibility Testing of Web Applications in Agile Environments reached 600 reads on June 12. \n ",
                1,
                3,
                5/*,
                "11:20 a.m. - 14 jun. 19"*/

            )
        )

        iniciarRecylerView(lista, this, rv_tweets)


    }

    fun iniciarRecylerView(
        lista: List<Tweet>,
        actividad: ReciclerView,
        recycler_view: RecyclerView
    ) {
        val adaptadorTweet = AdaptadorTweet(
            lista,
            actividad,
            recycler_view
        )
        recycler_view.adapter = adaptadorTweet
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.layoutManager = LinearLayoutManager(actividad)

        adaptadorTweet.notifyDataSetChanged()
    }

    fun irAMostrarTweet(tweet: Tweet){
        val intentExplicito = Intent(
            this,
            MostrarTweet::class.java
        )

        intentExplicito.putExtra("tweet",tweet)
        startActivity(intentExplicito)
    }


    /*fun cambiarNombreTextView(texto: String) {
        txv_titulo_rv.text = texto
    }*/


}