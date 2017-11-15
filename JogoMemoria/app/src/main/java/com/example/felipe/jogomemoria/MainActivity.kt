package com.example.felipe.jogomemoria

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import com.example.felipe.jogomemoria.R.drawable.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var ltMain: LinearLayout
    lateinit var ibMain: ImageView
    lateinit var ltParams: LayoutParams
    var randArray = intArrayOf(-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1)
    var aux = -1
    var aux2 = -1
    var idaux = -1
    var rand: Random = Random()
    var imgs = intArrayOf(rato,burro,ovelha,vaca,peru,pardal,tubarao,esquilo)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ltMain = findViewById(R.id.ltMain)
        ltParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,1f)

        for(i in 0..3){
            val layout = LinearLayout(this)
            layout.layoutParams = ltParams
            layout.orientation = LinearLayout.HORIZONTAL
            ltMain.addView(layout)
            for (j in 0..3){
                val layout2 = LinearLayout(this)
                ltParams.setMargins(2,2,2,2)
                layout2.layoutParams = ltParams
                layout.addView(layout2)
                layout2.setBackgroundColor(Color.DKGRAY)

                ibMain = ImageView(this)
                ibMain.id = 4*i+j
                ibMain.layoutParams = ltParams
                ibMain.setBackgroundResource(R.color.primary_material_dark)
                layout2.addView(ibMain)
                ibMain.setOnClickListener({onClick(it)})
            }
        }
        embaralha()
    }

    fun onClick(view: View) {
        val bt = view as ImageView
        if(idaux == -1) {
            idaux = bt.id
            bt.setBackgroundResource(imgs[randArray[idaux]])
        }else{
            val bt2 = findViewById<ImageView>(idaux)
            if (randArray[idaux] == randArray[bt.id]) {
                bt.setBackgroundResource(imgs[randArray[bt.id]])
                bt2.setBackgroundResource(imgs[randArray[idaux]])
                bt.isClickable = false
                bt2.isClickable = false
            }else{
                bt.setBackgroundResource(imgs[randArray[bt.id]])
                bt2.setBackgroundResource(imgs[randArray[idaux]])
                bt.setBackgroundResource(R.color.primary_material_dark)
                bt2.setBackgroundResource(R.color.primary_material_dark)
            }
            idaux = -1
        }
    }

    fun embaralha(){
        for (i in 0..7){
            do {
                aux = rand.nextInt(16)
                aux2 = rand.nextInt(16)
            }while ((randArray[aux] != -1) || (randArray[aux2] != -1) || (aux == aux2))
            randArray[aux] = i
            randArray[aux2] = i
        }
    }
}
