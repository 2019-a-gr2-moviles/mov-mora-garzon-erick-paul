package com.example.twitter

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class AdaptadorComentario(
    private val listaComentarios: List<Comentario>,
    private val contexto: MostrarTweet,
    private val recyclerView: RecyclerView
) :
    RecyclerView.Adapter<AdaptadorComentario.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //var fotoPerfilCom: ImageView
        var autorComTextView: TextView
        var nombreUsuarioComTextView: TextView
        var tiempoComTextView: TextView
        var contenidoComTextView: TextView
        /*var numComentariosTextView: TextView
        var numReTextView: TextView
        var numMeGustaTextView: TextView*/
        var idComentario: Int = 0
        /* var numComentariosTextView: Int = 0
         var numReTextView: Int = 0
         var numMeGustaTextView: Int = 0*/
        //var fechaTextView: TextView
        //var accionBoton: Button

        init {
            //fotoPerfilCom = view.findViewById(R.id.img_perfil_com) as ImageView
            autorComTextView = view.findViewById(R.id.txt_autor_com) as TextView
            nombreUsuarioComTextView = view.findViewById(R.id.txt_nombreUsuario_com) as TextView
            tiempoComTextView = view.findViewById(R.id.txt_tiempo_com) as TextView
            contenidoComTextView = view.findViewById(R.id.txt_contenido_com) as TextView
            /*numComentariosTextView = view.findViewById(R.id.txt_numComentarios) as TextView
            numReTextView = view.findViewById(R.id.txt_numRe) as TextView
            numMeGustaTextView = view.findViewById(R.id.txt_numMeGusta) as TextView*/
            //fechaTextView = view.findViewById(R.id.txt_fecha) as TextView
            //accionBoton = view.findViewById(R.id.btn_accion) as Button

            val layout = view.findViewById(R.id.constraint_layout) as ConstraintLayout

            layout.setOnClickListener {
                val comentario = Comentario(
                    idComentario,
                    autorComTextView.text.toString(),
                    nombreUsuarioComTextView.text.toString(),
                    tiempoComTextView.text.toString(),
                    contenidoComTextView.text.toString()/*,
                    Integer.parseInt(numComentariosTextView.text.toString()),
                    Integer.parseInt(numReTextView.text.toString()),
                    Integer.parseInt(numMeGustaTextView.text.toString())*//*,
                            fechaTextView.text.toString()*/
                )
                //irAMostrarTweet(comentario)

                Log.i("recycler-view","Layout presionado")
            }


        }

        /*fun irAMostrarTweet(comentario:Comentario){
            contexto.irAMostrarTweet(comentario)
        }*/

    }
    //Esta funcion define el template que vamos a utilizar
    //El template está en la carpeta de res/layout
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdaptadorComentario.MyViewHolder {

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
        return listaComentarios.size
    }

    override fun onBindViewHolder(myViewHolder: AdaptadorComentario.MyViewHolder, position: Int) {
        val comentario = listaComentarios[position]
        myViewHolder.idComentario = comentario.idComentario
        myViewHolder.autorComTextView.text = comentario.autorCom
        myViewHolder.nombreUsuarioComTextView.text = comentario.nombreDeUsuarioCom
        myViewHolder.tiempoComTextView.text = comentario.tiempoCom
        myViewHolder.contenidoComTextView.text = comentario.contenidoCom
        /*myViewHolder.numComentariosTextView.text = tweet.numComentarios.toString()
        myViewHolder.numReTextView.text = tweet.numRe.toString()
        myViewHolder.numMeGustaTextView.text = tweet.numMeGusta.toString()*/
        //myViewHolder.fechaTextView.text = tweet.fecha

        /*when (comentario.idComentario){
            1 -> {
                myViewHolder.fotoPerfilCom.setImageResource(R.drawable.foto_com1)

            }
            2 -> {
                myViewHolder.fotoPerfilCom.setImageResource(R.drawable.foto_com2)

            }
            3 -> {
                myViewHolder.fotoPerfilCom.setImageResource(R.drawable.foto_com3)

            }
        }*/
    }


}