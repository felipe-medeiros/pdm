package com.example.felipe.meuslugares

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.annotation.RequiresApi
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import java.time.LocalDateTime

class CarregaActivity : AppCompatActivity() {

    lateinit var etNome: EditText
    lateinit var etDesc: EditText
    lateinit var btFoto: Button
    lateinit var btSalvar: Button
    lateinit var ivFoto: ImageView
    lateinit var bmFoto: Bitmap
    val REQUEST_PHOTO = 1

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("ServiceCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrega)

        this.btFoto = findViewById(R.id.btFoto)
        this.btSalvar = findViewById(R.id.btSalvar)
        this.etDesc = findViewById(R.id.etDesc)
        this.etNome = findViewById(R.id.etNome)
        this.ivFoto = findViewById(R.id.ivFoto)

        this.btFoto.setOnClickListener({
            val it = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(it, REQUEST_PHOTO)
        })
        this.btSalvar.setOnClickListener({salvar(it)})
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun salvar(view: View){
        val it = Intent(this, MainActivity::class.java)
        it.putExtra("Nome", this.etNome.text.toString())
        it.putExtra("Desc", this.etDesc.text.toString())
        this.ivFoto.buildDrawingCache()
        this.bmFoto = this.ivFoto.drawingCache
        it.putExtra("Foto", this.bmFoto)
        val datahora = LocalDateTime.now()
        it.putExtra("Hora", datahora.toString())
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
}
