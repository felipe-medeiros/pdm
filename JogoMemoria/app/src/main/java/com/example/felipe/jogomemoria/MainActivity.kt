package com.example.felipe.jogomemoria

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import com.example.felipe.jogomemoria.R.drawable.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var ltMain: LinearLayout
    lateinit var ibMain: ImageView
    lateinit var ltParams: LayoutParams
    lateinit var ibVer: Button
    var rand: Random = Random()
    var imgs = intArrayOf(rato,burro,ovelha,vaca,peru,pardal,tubarao,esquilo,
            rato,burro,ovelha,vaca,peru,pardal,tubarao,esquilo)

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
                ibMain.layoutParams = ltParams
                ibMain.setBackgroundResource(imgs[4*i+j])
                ibMain.visibility = View.VISIBLE
                layout2.addView(ibMain)
                ibMain.setOnClickListener({onClick(it)})
            }
        }
    }

    fun onClick(view: View) {
        var bt = view as ImageView
        bt.visibility = View.VISIBLE
    }
}
