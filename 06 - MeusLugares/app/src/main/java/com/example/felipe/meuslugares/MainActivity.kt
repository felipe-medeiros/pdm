package com.example.felipe.meuslugares

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    lateinit var lista: ListView
    lateinit var btNovo: Button
    var lugares = ArrayList<Lugar>()

    val NOVO_LUGAR = 1

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.lista = findViewById(R.id.lista)
        this.lista.adapter = ArrayAdapter<Lugar>(this, android.R.layout.simple_list_item_1, lugares)


        this.btNovo = findViewById(R.id.btMainNovo)

        this.btNovo.setOnClickListener({
            val it = Intent(this,CarregaActivity::class.java)
            startActivityForResult(it, NOVO_LUGAR)
        })
        this.lista.setOnItemClickListener({parent, view, position, id ->
            val it = Intent(this, ExibeActivity::class.java)
            val lugar = lugares[position]
            it.putExtra("Lugar", lugar)
            startActivity(it)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            if(requestCode == NOVO_LUGAR){
                val lugar = data?.getParcelableExtra<Lugar>("Lugar")
                (this.lista.adapter as ArrayAdapter<Lugar>).add(lugar)
            }
        }
    }
}
