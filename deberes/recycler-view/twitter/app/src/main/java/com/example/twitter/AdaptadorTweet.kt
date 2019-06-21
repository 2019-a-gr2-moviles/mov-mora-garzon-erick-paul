package com.example.twitter

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class AdaptadorTweet(
    private val listaTweets: List<Tweet>,
    private val contexto: ReciclerView,
    private val recyclerView: RecyclerView
) :
    RecyclerView.Adapter<AdaptadorTweet.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var fotoPerfil: ImageView
        var fotoTweet: ImageView
        var autorTextView: TextView
        var nombreUsuarioTextView: TextView
        var tiempoTextView: TextView
        var contenidoTextView: TextView
        var numComentariosTextView: TextView
        var numReTextView: TextView
        var numMeGustaTextView: TextView
        var idUsuario: Int = 0
       /* var numComentariosTextView: Int = 0
        var numReTextView: Int = 0
        var numMeGustaTextView: Int = 0*/
        //var fechaTextView: TextView
        //var accionBoton: Button

        init {
            fotoPerfil = view.findViewById(R.id.img_perfil) as ImageView
            fotoTweet = view.findViewById(R.id.img_tweet) as ImageView
            autorTextView = view.findViewById(R.id.txt_autor) as TextView
            nombreUsuarioTextView = view.findViewById(R.id.txt_nombreUsuario) as TextView
            tiempoTextView = view.findViewById(R.id.txt_tiempo) as TextView
            contenidoTextView = view.findViewById(R.id.txt_contenido) as TextView
            numComentariosTextView = view.findViewById(R.id.txt_numComentarios) as TextView
            numReTextView = view.findViewById(R.id.txt_numRe) as TextView
            numMeGustaTextView = view.findViewById(R.id.txt_numMeGusta) as TextView
            //fechaTextView = view.findViewById(R.id.txt_fecha) as TextView
            //accionBoton = view.findViewById(R.id.btn_accion) as Button

            val layout = view.findViewById(R.id.constraint_layout) as ConstraintLayout

            layout.setOnClickListener {
                val tweet = Tweet(
                            idUsuario,
                            autorTextView.text.toString(),
                            nombreUsuarioTextView.text.toString(),
                            tiempoTextView.text.toString(),
                            contenidoTextView.text.toString(),
                            Integer.parseInt(numComentariosTextView.text.toString()),
                            Integer.parseInt(numReTextView.text.toString()),
                            Integer.parseInt(numMeGustaTextView.text.toString())/*,
                            fechaTextView.text.toString()*/
                )
                irAMostrarTweet(tweet)

                Log.i("recycler-view","Layout presionado")
            }


        }

        fun irAMostrarTweet(tweet:Tweet){
            contexto.irAMostrarTweet(tweet)
        }

    }
    //Esta funcion define el template que vamos a utilizar
    //El template está en la carpeta de res/layout
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdaptadorTweet.MyViewHolder {

        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layout,
                p0,
                false
            )

        return MyViewHolder(itemView)
    }

    //Devuelve el # de items de la lista
    override fun getItemCount(): Int {
        return listaTweets.size
    }

    override fun onBindViewHolder(myViewHolder: AdaptadorTweet.MyViewHolder, position: Int) {
        val tweet = listaTweets[position]
        myViewHolder.idUsuario = tweet.idUsuario
        myViewHolder.autorTextView.text = tweet.autor
        myViewHolder.nombreUsuarioTextView.text = tweet.nombreDeUsuario
        myViewHolder.tiempoTextView.text = tweet.tiempo
        myViewHolder.contenidoTextView.text = tweet.contenido
        myViewHolder.numComentariosTextView.text = tweet.numComentarios.toString()
        myViewHolder.numReTextView.text = tweet.numRe.toString()
        myViewHolder.numMeGustaTextView.text = tweet.numMeGusta.toString()
        //myViewHolder.fechaTextView.text = tweet.fecha

        when (tweet.idUsuario){
            1 -> {
                myViewHolder.fotoPerfil.setImageResource(R.drawable.foto1)
                myViewHolder.fotoTweet.setImageResource(R.drawable.tweet1)
            }
            2 -> {
                myViewHolder.fotoPerfil.setImageResource(R.drawable.foto2)
                myViewHolder.fotoTweet.setImageResource(R.drawable.tweet2)
            }
            3 -> {
                myViewHolder.fotoPerfil.setImageResource(R.drawable.foto3)
                myViewHolder.fotoTweet.setImageResource(R.drawable.tweet3)
            }
        }
    }


}