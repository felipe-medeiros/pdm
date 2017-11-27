package com.example.felipe.meuslugares

import android.annotation.SuppressLint
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
    lateinit var local: String
    lateinit var lista: ListView
    lateinit var btNovo: Button
    var lugares = ArrayList<Lugar>()
    var nomes = arrayListOf<String>("eu")

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
        Log.i("DEBBUG", "entrou result")
        if(requestCode == NOVO_LUGAR){
            Log.i("DEBBUG", "entrou if")
            val lugar = Lugar()
            val teste = data?.getStringExtra("Nome")
            Log.i("DEBBUG", teste)
            lugar.nome = data?.getStringExtra("Nome")
            lugar.desc = data?.getStringExtra("Desc")
            lugar.foto = data?.getParcelableExtra("Foto")
            lugar.local = this@MainActivity.local
            lugar.hora = data?.getStringExtra("Hora")
            this@MainActivity.lugares.add(lugar)
            (this@MainActivity.lista.adapter as ArrayAdapter<String>).add(lugar.nome)
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
