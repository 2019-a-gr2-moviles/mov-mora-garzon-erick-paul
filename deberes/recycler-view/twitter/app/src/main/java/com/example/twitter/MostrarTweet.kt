package com.example.twitter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_mostrar_tweet.*

class MostrarTweet : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_tweet)

        val tweet: Tweet?= this.intent.getParcelableExtra<Tweet>("tweet")

        txt_autor2.text = tweet?.autor
        txt_nombreUsuario2.text = tweet?.nombreDeUsuario
        txt_contenido2.text = tweet?.contenido
        //txt_fecha.text = tweet?.fecha
        txt_numRe2.text = tweet?.numRe.toString()
        txt_numMeGusta2.text = tweet?.numMeGusta.toString()

    }
}
