package com.example.felipe.jogoarrocha

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvMaior = findViewById(R.id.tvMainMaior)
        this.tvMenor = findViewById(R.id.tvMainMenor)
        this.etChute = findViewById(R.id.etMainChute)
        this.btChute = findViewById(R.id.btMainChute)
        this.btChute.setOnClickListener({verifica(etChute)})
    }

    fun verifica(view: View,menor: Int=2,maior: Int=99): Int{
        var intchute = etChute.text as Int
        if (intchute == segredo)
            return -1
        else if (intchute > maior || intchute < menor)
            return -1
        else if ((maior - menor) == 2)
            return 1
        else if (intchute < maior && intchute > menor){
            if (intchute > segredo){
                tvMaior.text = intchute as String
                return 0
            }else if (intchute < segredo){
                tvMenor.text = intchute as String
                return 0
            }
        }
        return -1
    }
}
