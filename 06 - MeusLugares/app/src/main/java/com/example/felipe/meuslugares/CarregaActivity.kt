package com.example.felipe.meuslugares

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.annotation.RequiresApi
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import java.time.Instant
import java.util.*

class CarregaActivity : AppCompatActivity() {

    lateinit var etNome: EditText
    lateinit var etDesc: EditText
    lateinit var btFoto: Button
    lateinit var btSalvar: Button
    lateinit var ivFoto: ImageView
    lateinit var gpsManager: LocationManager
    lateinit var gpsListener: LocationListener
    var local: Location? = null
    val REQUEST_PHOTO = 1

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("ServiceCast", "MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrega)

        this.btFoto = findViewById(R.id.btFoto)
        this.btSalvar = findViewById(R.id.btSalvar)
        this.etDesc = findViewById(R.id.etDesc)
        this.etNome = findViewById(R.id.etNome)
        this.ivFoto = findViewById(R.id.ivFoto)

        this.gpsListener = GPSListener()
        this.gpsManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        this.gpsManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 0f, this.gpsListener)

        this.btFoto.setOnClickListener({
            val it = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(it, REQUEST_PHOTO)
        })
        this.btSalvar.setOnClickListener({salvar(it)})
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun salvar(view: View){
        val it = Intent()
        it.putExtra("Lugar", Lugar(
                this.etNome.text.toString(),
                this.etDesc.text.toString(),
                (this.ivFoto.drawable as BitmapDrawable).bitmap,
                this.local,
                Date().toString()
        ))
        setResult(Activity.RESULT_OK, it)
        finish()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_PHOTO){
            val img = data?.extras
            this.ivFoto.setImageBitmap(img?.get("data") as Bitmap)
        }
    }

    inner class GPSListener: LocationListener {
        override fun onLocationChanged(location: Location?) {
            this@CarregaActivity.local = location
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
}
