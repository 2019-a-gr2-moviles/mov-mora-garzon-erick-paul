package com.example.a03_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val listaNombres = arrayListOf<String>()
        listaNombres.add("Vicente")
        listaNombres.add("Carolina")
        listaNombres.add("Felipe")
        listaNombres.add("Johanna")

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, listaNombres)

        lv_ejemplo.adapter = adapter

        lv_ejemplo.onItemClickListener = AdapterView.OnItemClickListener {
                parent, view, position, id ->
            Log.i("list-view", "Posicion $position")


        }

    }

   /* fun mostrarSnack(view: View, texto:String){
        Snackbar
            .make(view, "Gracias por crear un nuevo usuario", Snackbar.LENGTH_LONG)
            .setAction("Action", null)

    }*/
}
