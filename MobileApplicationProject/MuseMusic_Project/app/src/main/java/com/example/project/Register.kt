package com.example.project

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {
    var mAuth: FirebaseAuth? = null
    private val TAG: String = "Register Activity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(MainActivity.currentTheme[MainActivity.themeIndex])
        setContentView(R.layout.activity_register)
        mAuth = FirebaseAuth.getInstance()
        if (mAuth!!.currentUser != null) {
            startActivity(Intent(this@Register, MainActivity::class.java))
            finish()
        }
        register_registerBtn.setOnClickListener {
            val email = register_emailEditText.text.toString().trim { it <= ' ' }
            val password = register_passwordEditText.text.toString().trim { it <= ' ' }
//ทําการตรวจสอบก่อนว่ามีข้อมูลหรือไม่
            if (email.isEmpty()) {
                Toast.makeText(this,"Please enter your email address.", Toast.LENGTH_LONG).show()
                Log.d(TAG, "Email was empty!")
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                Toast.makeText(this,"Please enter your password.",Toast.LENGTH_LONG).show()
                Log.d(TAG, "Password was empty!")
                return@setOnClickListener
            }
//กรณีที่มีข้อมูล จะทําการตรวจสอบเงื่อนไขอื่น ๆ ก่อนทําการ create user
            mAuth!!.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    if (password.length < 6) { // ตรวจสอบความยาวของ password
                        Toast.makeText(this,"Password too short! Please enter minimum 6 characters.",Toast.LENGTH_LONG).show()
                                Log.d(TAG, "Enter password less than 6 characters.")
                    } else {
                        Toast.makeText(this,"Authentication Failed: " +
                            task.exception!!.message,Toast.LENGTH_LONG).show()
                        Log.d(TAG, "Authentication Failed: " + task.exception!!.message)
                    }
                } else {
                    Toast.makeText(this,"Create account successfully!",Toast.LENGTH_LONG).show()
                    Log.d(TAG, "Create account successfully!")
                    startActivity(Intent(this@Register, MainActivity::class.java))
                    finish()
                }
            }
        }
        register_signinBtn.setOnClickListener { startActivity(Intent(this@Register, LogIn::class.java))
        }
    }
}