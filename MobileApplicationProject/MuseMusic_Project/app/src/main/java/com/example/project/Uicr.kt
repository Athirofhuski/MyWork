package com.example.project.model

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.project.R
import com.example.project.Shop

class Uicr : AppCompatActivity() {

    var btn_next   : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uicre)

        btn_next = findViewById(R.id.btn_next)
        btn_next!!.setOnClickListener {
            var intent = Intent(this, Shop::class.java)
            startActivity(intent)
        }
    }
}