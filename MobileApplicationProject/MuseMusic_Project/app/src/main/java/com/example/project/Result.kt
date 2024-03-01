package com.example.project

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_result.*

class Result: AppCompatActivity() {
    var mAuth: FirebaseAuth? = null
    var mAuthListener: FirebaseAuth.AuthStateListener? = null
    var mback : Button? = null
    var themebtn : Button? = null
    var sr_p    : ImageButton? = null
    var hr_p    : ImageButton? = null
    var gr_p    : ImageButton? = null
    var ser_p    : ImageButton? = null

    var ThemeBtn : ImageButton? = null
    var AboutBtn : ImageButton? = null

    private val TAG:String = "Result Activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(MainActivity.currentTheme[MainActivity.themeIndex])
        setContentView(R.layout.activity_result)

        ThemeBtn = findViewById(R.id.ThemeBtn)
        ThemeBtn!!.setOnClickListener{
            startActivity(Intent(this@Result, ThemeActivity::class.java))
        }

        AboutBtn = findViewById(R.id.AboutBtn)
        AboutBtn!!.setOnClickListener{
            startActivity(Intent(this@Result, AboutActivity::class.java))
        }

        // การทํางานของปุ่ม Sign out
        result_signOutBtn.setOnClickListener {
            mAuth!!.signOut()
            Toast.makeText(this,"Signed out!", Toast.LENGTH_LONG).show()
            Log.d(TAG, "Signed out!")
            startActivity(Intent(this@Result, LogIn::class.java))
            finish()
        }


        sr_p = findViewById(R.id.sr_p)
        hr_p = findViewById(R.id.hr_p)
        gr_p = findViewById(R.id.gr_p)
        ser_p = findViewById(R.id.ser_p)
        sr_p!!.setOnClickListener {
            var intent = Intent(this, Shop::class.java)
            startActivity(intent)
        }

        hr_p!!.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        gr_p!!.setOnClickListener {
            var intent = Intent(this, Game::class.java)
            startActivity(intent)
        }

        ser_p!!.setOnClickListener {
            var intent = Intent(this, Result::class.java)
            startActivity(intent)
        }
//ดึงค่าจาก Firebase มาใส่ใน mAuth
        mAuth = FirebaseAuth.getInstance()
        val user = mAuth!!.currentUser
//นําค่ามาใส่ลงใน TextView ที่สร้างขึ้น
        result_emailData.text = user!!.email
        result_uidData.text = user.uid
        mAuthListener = FirebaseAuth.AuthStateListener { firebaseAuth ->
            val users = firebaseAuth.currentUser
            if (users == null) {
                startActivity(Intent(this@Result, LogIn::class.java))
                finish()
            }
        }

//        mback = findViewById(R.id.btnback)
//        mback!!.setOnClickListener {
//            var intent = Intent(this@Result, MainActivity::class.java)
//            startActivity(intent)
//        }

    }
    override fun onStart() {
        super.onStart()
        mAuth!!.addAuthStateListener { mAuthListener }
    }
    override fun onStop() {
        super.onStop()
        if (mAuthListener != null) { mAuth!!.removeAuthStateListener { mAuthListener } }
    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) { moveTaskToBack(true) }
        return super.onKeyDown(keyCode, event)
    }
}