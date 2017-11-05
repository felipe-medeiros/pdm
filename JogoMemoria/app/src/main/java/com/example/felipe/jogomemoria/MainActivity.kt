package com.example.felipe.jogomemoria

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {

    lateinit var ltMain: LinearLayout
    lateinit var ibMain: ImageButton
    lateinit var ltParams: LinearLayout.LayoutParams

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ltMain = findViewById(R.id.ltMain)
        ltParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT,1f)

        for(i in 1..4){
            val layout = LinearLayout(this)
            layout.layoutParams = ltParams
            layout.orientation = LinearLayout.HORIZONTAL
            for (j in 1..4){
                ibMain = ImageButton(this)
                ibMain.layoutParams = ltParams
                layout.addView(ibMain)
                ibMain.setOnClickListener({onClick(it)})
            }
            ltMain.addView(layout)
        }
    }

    fun onClick(view: View){
        view.setBackgroundResource(R.drawable.login_hdpi)
    }
}
