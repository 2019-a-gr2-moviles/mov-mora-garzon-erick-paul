package com.example.a03_android

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

open class Parcelable : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parcelable)


    val erick: Usuario? = this.intent.getParcelableExtra<Usuario>("usuario")
        val cachetes: Mascota? = this.intent.getParcelableExtra<Mascota>("mascota")

    Log.i("parcelable","Nombre ${erick?.nombre}")
    Log.i("parcelable","Edad ${erick?.edad}")
    Log.i("parcelable","Fecha Nacimiento ${erick?.fechaNacimiento.toString()}")
    Log.i("parcelable","Sueldo ${erick?.sueldo}")

        Log.i("parcelable","Nombre: ${cachetes?.nombre}")
        Log.i("parcelable","Duenio: ${cachetes?.duenio?.nombre}")

    }

    fun regresarAMenu(){
        val intentExplicito = Intent(
            this,
            MainActivity::class.java
        )
        startActivity(intentExplicito)
    }

}
