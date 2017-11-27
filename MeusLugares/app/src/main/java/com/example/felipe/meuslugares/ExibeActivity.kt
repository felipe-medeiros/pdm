package com.example.felipe.meuslugares

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView

class ExibeActivity : AppCompatActivity() {

    lateinit var etNome: EditText
    lateinit var etDesc: EditText
    lateinit var ivFoto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exibe)

        this.etDesc = findViewById(R.id.etExibeDesc)
        this.etNome = findViewById(R.id.etExibeNome)
        this.ivFoto = findViewById(R.id.ivExibeFoto)

    }
}
