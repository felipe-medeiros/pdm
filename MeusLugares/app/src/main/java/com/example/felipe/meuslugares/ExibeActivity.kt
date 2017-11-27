package com.example.felipe.meuslugares

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ExibeActivity : AppCompatActivity() {

    lateinit var tvNome: TextView
    lateinit var tvDesc: TextView
    lateinit var tvHora: TextView
    lateinit var tvGPS: TextView
    lateinit var ivFoto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exibe)

        this.tvNome = findViewById(R.id.tvNome)
        this.tvDesc = findViewById(R.id.tvDesc)
        this.ivFoto = findViewById(R.id.ivExibeFoto)
        this.tvGPS = findViewById(R.id.tvGPS)
        this.tvHora = findViewById(R.id.tvHora)
    }
}
