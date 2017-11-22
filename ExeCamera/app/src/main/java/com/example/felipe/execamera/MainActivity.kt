package com.example.felipe.execamera

import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btMain: Button
    var foto = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btMain = findViewById(R.id.btMain)
        btMain.setOnClickListener({
            val it = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(it, foto)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == foto){
            val it = Intent ()
            val img = data?.extras
            it.action = Intent.ACTION_SEND
            it.type = "image/*"
            it.putExtra(Intent.EXTRA_STREAM, img)
            startActivity(it)
        }
    }
}
