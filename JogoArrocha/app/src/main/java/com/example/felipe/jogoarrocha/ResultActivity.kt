package com.example.felipe.jogoarrocha

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    lateinit var tvResult: TextView
    lateinit var tvSeg: TextView
    lateinit var btResult: Button
    lateinit var layout: LinearLayout
    lateinit var tvScore: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        this.tvResult = findViewById(R.id.tvResultTexto)
        this.tvResult.text = intent.getStringExtra("resultado")

        this.tvSeg = findViewById(R.id.tvResultSeg)
        this.tvSeg.text = intent.getStringExtra("segredo")

        this.layout = findViewById(R.id.layoutResult)

        this.btResult = findViewById(R.id.btResultVoltar)
        btResult.setOnClickListener({onClick(it)})

        this.tvScore = findViewById(R.id.tvResultScore)
        this.tvScore.text = intent.getStringExtra("score")

        if (this.tvResult.text.equals("Ganhou!")) {
            this.layout.setBackgroundColor(Color.GREEN)
        }else if (this.tvResult.text.equals("Perdeu!")){
            this.layout.setBackgroundColor(Color.RED)
        }
    }

    fun onClick(view: View){
        val it = Intent(this, MainActivity::class.java)
        startActivity(it)
    }
}
