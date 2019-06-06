package com.example.examen

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.util.Log

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        btnEntrar.setOnClickListener{
            irAMenuPrincipal()
        }


    }

    fun irAMenuPrincipal(){
        val intentExplicito = Intent(
            this,
            Principal::class.java
        )
        val usuario = Usuario("Erick Mora")
        intentExplicito.putExtra("usuario",usuario)
        if(usuario.nombre == tBUsuario.text.toString()){
            startActivity(intentExplicito)
        }else{
            Log.i("error","nombre incorrecto")
        }


    }


}
