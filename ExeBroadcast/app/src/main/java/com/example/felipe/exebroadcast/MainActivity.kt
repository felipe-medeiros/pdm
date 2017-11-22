package com.example.felipe.exebroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var tvMain: TextView
    lateinit var filter: IntentFilter
    lateinit var receiver: AviaoReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        receiver = AviaoReceiver()
        tvMain = findViewById(R.id.tvMain)
        filter = IntentFilter()
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
    }

    override fun onResume() {
        super.onResume()

        registerReceiver(receiver, filter)
    }

    inner class AviaoReceiver: BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            var msg = ""
            if(Intent.ACTION_AIRPLANE_MODE_CHANGED == intent?.action){
                msg = "Modo avião trocado."
            }else{
                msg = "Nada feito."
            }
            this@MainActivity.tvMain.text = msg
        }
    }
}
