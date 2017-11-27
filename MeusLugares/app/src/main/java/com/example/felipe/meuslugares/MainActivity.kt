package com.example.felipe.meuslugares

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var gpsManager: LocationManager
    lateinit var gpsListener: LocationListener
    lateinit var lugar: Lugar
    lateinit var local: String
    lateinit var lista: ListView
    lateinit var btNovo: Button
    var lugares = arrayListOf<Lugar>()
    var nomes = arrayListOf<String>()

    val NOVO_LUGAR = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.lista = findViewById(R.id.lista)
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomes)
        this.lista.adapter = adapter

        this.btNovo = findViewById(R.id.btMainNovo)
        this.btNovo.setOnClickListener({onClick(it)})

        this.gpsManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        this.gpsListener = GPSListener()

        this.lista.setOnItemClickListener({parent, view, position, id ->
            val it = Intent(this, ExibeActivity::class.java)

        })
    }

    @SuppressLint("MissingPermission")
    override fun onResume() {
        super.onResume()
        this.gpsManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 0f, this.gpsListener)
    }

    fun onClick(view: View){
        val it = Intent(this,CarregaActivity::class.java)
        startActivityForResult(it, NOVO_LUGAR)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            if(requestCode == NOVO_LUGAR){
                this.lugar = Lugar()
                this.lugares.add(lugar)
                this.lugar.nome = data?.getStringExtra("Nome")
                this.lugar.desc = data?.getStringExtra("Desc")
                this.lugar.foto = data?.getParcelableExtra("Foto")
                this.lugar.hora = data?.getStringExtra("Hora")
                //this.lugar.local = this@MainActivity.local
            }
            (this.lista.adapter as ArrayAdapter<String>).add(this.lugar.nome.toString())
        }
    }

    inner class GPSListener: LocationListener {
        override fun onLocationChanged(location: Location?) {
            this@MainActivity.local = "${location?.latitude} - ${location?.longitude}"
        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onProviderEnabled(provider: String?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onProviderDisabled(provider: String?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    inner class Lugar(){
        public var nome: String? = null
        public var desc: String? = null
        public var foto: Bitmap? = null
        public var local: String? = null
        public var hora: String? = null
    }
}
