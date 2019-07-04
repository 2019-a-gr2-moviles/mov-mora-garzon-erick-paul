package com.example.a03_android

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado_propio.*

class ResultadoPropioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_propio)

        btn_devolver_respuesta.setOnClickListener{
            devolverRespuesta()
        }
    }

    fun devolverRespuesta(){
        val nombre = "Erick"
        val edad = 22

        val intentRespuesta = Intent()

        intentRespuesta.putExtra("nombreUsuario",nombre)
        intentRespuesta.putExtra("edadUsuario",edad)

        this.setResult(
            Activity.RESULT_OK, //Podemos enviar RESULT_OK o RESULT_CANCELLED
            intentRespuesta
        )

        this.finish()
    }
}
