package com.example.twitter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_mostrar_tweet.*

class MostrarTweet : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_tweet)




        val listaCom = arrayListOf<Comentario>()
        listaCom.add(
            Comentario(
                1,
                "Alejandro Jodorow",
                "@alejodo",
                "1d",
                "Muy bien"/*,
                "11:36 a.m. - 18 jun 19"*/
            )
        )
        listaCom.add(
            Comentario(
                2,
                "El Comercio",
                "@elcomercio",
                "7h",
                "Interesante"/*,
                "7:33 p.m. - 19 jun 19"*/
            )
        )
        listaCom.add(
            Comentario(
                3,
                "Sandra Sanchez",
                "@KushiRimay",
                "14 jun",
                ":)"/*,
                "11:20 a.m. - 14 jun. 19"*/

            )
        )

        iniciarRecylerView(listaCom, this, rv_comentarios)












        val tweet: Tweet?= this.intent.getParcelableExtra<Tweet>("tweet")

        txt_autor2.text = tweet?.autor
        txt_nombreUsuario2.text = tweet?.nombreDeUsuario
        txt_contenido2.text = tweet?.contenido
        //txt_fecha.text = tweet?.fecha
        txt_numRe2.text = tweet?.numRe.toString()
        txt_numMeGusta2.text = tweet?.numMeGusta.toString()

        when (tweet?.idUsuario){
            1 -> {
                img_perfil2.setImageResource(R.drawable.foto1)
                img_tweet2.setImageResource(R.drawable.tweet1)
            }
            2 -> {
                img_perfil2.setImageResource(R.drawable.foto2)
                img_tweet2.setImageResource(R.drawable.tweet2)
            }
            3 -> {
                img_perfil2.setImageResource(R.drawable.foto3)
                img_tweet2.setImageResource(R.drawable.tweet3)
            }
        }

    }















    fun iniciarRecylerView(
        lista: List<Comentario>,
        actividad: MostrarTweet,
        recycler_view: RecyclerView
    ) {
        val adaptadorComentario = AdaptadorComentario(
            lista,
            actividad,
            recycler_view
        )
        recycler_view.adapter = adaptadorComentario
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.layoutManager = LinearLayoutManager(actividad)

        adaptadorComentario.notifyDataSetChanged()
    }




}
