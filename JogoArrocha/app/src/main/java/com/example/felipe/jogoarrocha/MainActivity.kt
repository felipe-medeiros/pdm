package com.example.felipe.jogoarrocha

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {

    lateinit var tvMenor: TextView
    lateinit var tvMaior: TextView
    lateinit var etChute: EditText
    lateinit var btChute: Button
    val random = Random()
    var segredo = random.nextInt(100)
    var score = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvMaior = findViewById(R.id.tvMainMaior)
        this.tvMenor = findViewById(R.id.tvMainMenor)
        this.etChute = findViewById(R.id.etMainChute)

        this.btChute = findViewById(R.id.btMainChute)
        this.btChute.setOnClickListener({onClick(it)})
    }

    fun onClick(view: View){
        val maior = tvMaior.text.toString().toInt()
        val menor = tvMenor.text.toString().toInt()
        val intchute = etChute.text.toString().toInt()
        val strsegredo = segredo.toString()

        val it = Intent(this, ResultActivity::class.java)

        if (intchute >= maior || intchute <= menor || intchute == segredo) {
            it.putExtra("resultado","Perdeu!")
            it.putExtra("segredo",strsegredo)
            it.putExtra("score",score.toString())
            startActivity(it)
        }else if ((intchute - menor) == 2 || (maior - intchute) == 2) {
            it.putExtra("resultado", "Ganhou!")
            it.putExtra("segredo",strsegredo)
            it.putExtra("score",score.toString())
            startActivity(it)
        }else if (intchute in menor+1 until maior){
            score -= 5
            if (intchute > segredo){
                tvMaior.text = intchute.toString()
            }else if (intchute < segredo){
                tvMenor.text = intchute.toString()
            }
            etChute.text.clear()
        }
    }
}
