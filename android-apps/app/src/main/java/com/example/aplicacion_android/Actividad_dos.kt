package com.example.aplicacion_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.MainActivity

class Actividad_dos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_dos)

        val nombre: String? = intent.getStringExtra("nombre")
        val edad: Int? = intent.getIntExtra("edad",0)

        Log.i("intents", "Nombre:" $nombre)
        Log.i("intents", "Edad:" $edad)

        btn_actividad_uno.setOnClickListener{
            irAActividadUno()
        }
    }

    fun irAActividadUno(){
        val intent = Intent(
                this,
                MainActivity::class.java
        )
    }
}
