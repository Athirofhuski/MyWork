package com.example.project

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_details.*

class ProductDetails : AppCompatActivity() {

    var sesss    : ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(MainActivity.currentTheme[MainActivity.themeIndex])
        setContentView(R.layout.product_details)
        setupLinkButton()

        btncopied.setOnClickListener {
            copyTextToClipboard()
        }

        sesss = findViewById(R.id.img_back)
        sesss!!.setOnClickListener {
            var intent = Intent(this, Shop::class.java)
            startActivity(intent)
        }

        val title = intent.getStringExtra("title")
        product_name.text = title

        val photoUrl = intent.getStringExtra("photo_url")
        Picasso.get().load(photoUrl).into(photo)

        val website = intent.getStringExtra("website")
        product_website.text = website


        }
/*
    fun setupActivityLink() {
        val website = findViewById<TextView>(R.id.product_website)
        website.setTextColor(Color.BLUE)
        website.setOnClickListener {
            val switchActivityIntent = Intent(Intent.putExtra("website", products[holder.adapterPosition].website))
            startActivity(switchActivityIntent)
        }
    }
*/
    private fun copyTextToClipboard() {
        val textToCopy = product_website.text

        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("website", textToCopy)
        clipboardManager.setPrimaryClip(clipData)

        Toast.makeText(this, "Text copied to clipboard", Toast.LENGTH_LONG).show()
    }

    fun setupLinkButton() {
        val linkButton = findViewById<TextView>(R.id.btnbrowser)
        linkButton.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))
            startActivity(browserIntent)
        }
    }
}
