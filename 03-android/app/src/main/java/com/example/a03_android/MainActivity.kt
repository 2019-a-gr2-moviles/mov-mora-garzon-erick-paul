package com.example.a03_android

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.view.View


import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_parcelable.setOnClickListener {
            irAParcelable()

        }

        btn_adapter.setOnClickListener {
            irAListView()
            mostrarSnack(it,"Texto snack")
        }

        btn_recycler_view.setOnClickListener {
            irARecyclerView()
        }

        btn_intent_respuesta.setOnClickListener {
            irAIntentRespuesta()
        }

        btn_http.setOnClickListener {
            irAIntentHttp()
        }

        btnMapa.setOnClickListener {
            irAMapa()
        }

        btn_ciclo_vida.setOnClickListener {
            irACicloDeVida()
        }

        btn_fragmento.setOnClickListener {
            irAFragmento()
        }



        //setSupportActionBar(toolbar)

        /*fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/
    }

    /*override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }*/



    fun irAParcelable(){
        val intentExplicito = Intent(
            this,
            Parcelable::class.java
        )
        val erick = Usuario("Erick", 22, Date(), 12.12)
        intentExplicito.putExtra("usuario",erick)

        val cachetes = Mascota("Cachetes", erick)
        intentExplicito.putExtra("mascota", cachetes)

        startActivity(intentExplicito)
    }

    fun irAListView(){
        val intentExplicito = Intent(
            this,
            ListViewActivity::class.java
        )
        startActivity(intentExplicito)
    }

    fun mostrarSnack(view: View, texto:String){
        Snackbar
            .make(view, texto, Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()

    }

    fun irARecyclerView(){
        val intentExplicito = Intent(
            this,
            ReciclerViewActivity::class.java
        )
        startActivity(intentExplicito)
    }

    fun irAIntentRespuesta(){
        val intentExplicito = Intent(
            this,
            IntentRespuestaActivity::class.java
        )
        startActivity(intentExplicito)
    }

    fun irAIntentHttp(){
        val intentExplicito = Intent(
            this,
            ConexionHttpActivity::class.java
        )
        startActivity(intentExplicito)
    }

    fun irAMapa(){
        val intentExplicito = Intent(
            this,
            MapsActivity::class.java
        )
        startActivity(intentExplicito)
    }

    fun irACicloDeVida(){
        val intentExplicito = Intent(
            this,
            CicloVidaActivity::class.java
        )
        startActivity(intentExplicito)
    }

    fun irAFragmento(){
        val intentExplicito = Intent(
            this,
            FragmentosActivity::class.java
        )
        startActivity(intentExplicito)
    }

}
