package com.example.project

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import mehdi.sakout.aboutpage.AboutPage
import mehdi.sakout.aboutpage.Element
import java.util.*

//import android.provider.CalendarContract;

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val aboutPage = AboutPage(this)
            .isRTL(false)
            .setImage(R.drawable.muse)
            .setDescription("About This App" +
                    "\nThank you to everyone who has supported us!!")
            .addItem(Element().setTitle("Version 1.1"))
            .addItem(Element().setTitle("CONNECT WITH US!"))
            .addGroup("About Athirat Takaikaew : ")
            .addInstagram("esmeraypimzharki") //Your instagram id
            .addEmail("athirat.t@kkumail.com")
            .addGroup("About Nuttakit Thaiputtra : ")
            .addInstagram("ss_ay_ju") //Your instagram id
            .addEmail("nuttakit.t@kkumail.com")
        //    .addWebsite("Your website/")
        //    .addYoutube("UCbekhhidkzkGryM7mi5Ys_w") //Enter your youtube link here (replace with my channel link)
        //    .addPlayStore("com.example.project") //Replace all this with your package name
            .addItem(createCopyright())
            .addItem(createBack())
            .create()
        setContentView(aboutPage)
    }

    private fun createCopyright(): Element {
        val copyright = Element()
        @SuppressLint("DefaultLocale") val copyrightString = String.format(
            "Copyright %d by Nuttakit and Athirat",
            Calendar.getInstance()[Calendar.YEAR]
        )
        copyright.title = copyrightString
        // copyright.setIcon(R.mipmap.ic_launcher);
        copyright.gravity = Gravity.CENTER
        copyright.onClickListener =
            View.OnClickListener {
                Toast.makeText(this@AboutActivity, copyrightString, Toast.LENGTH_SHORT).show()
            }
        return copyright
    }

    private fun createBack(): Element {
        val back = Element()
        @SuppressLint("DefaultLocale") val copyrightString = String.format(
            "Back To Settings",
            Calendar.getInstance()[Calendar.YEAR]
        )
        back.title = copyrightString
        // copyright.setIcon(R.mipmap.ic_launcher);
        back.gravity = Gravity.CENTER
        back.onClickListener =
            View.OnClickListener {
                Toast.makeText(this@AboutActivity, copyrightString, Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@AboutActivity, Result::class.java))
            }
        return back
    }

}