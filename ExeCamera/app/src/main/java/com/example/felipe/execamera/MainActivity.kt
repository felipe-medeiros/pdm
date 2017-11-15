package com.example.felipe.execamera

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btMain: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btMain = findViewById(R.id.btMain)
        btMain.setOnClickListener({
            val it = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(it)

        })
    }
}
