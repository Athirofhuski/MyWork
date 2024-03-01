package com.example.project

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RacingActivity : AppCompatActivity(),GameTask {
    lateinit var rootLayout : LinearLayout
    lateinit var startBtn : Button
    lateinit var mGameView : GameView
    lateinit var score : TextView
    var car_back : Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(MainActivity.currentTheme[MainActivity.themeIndex])
        setContentView(R.layout.activity_racingcar)
        startBtn = findViewById(R.id.startBtn)
        rootLayout = findViewById(R.id.rootLayout)
        score = findViewById(R.id.score)
        mGameView = GameView(this,this)
        car_back = findViewById(R.id.backBtn2)
        car_back!!.setOnClickListener {
            var intent = Intent(this, Game::class.java)
            startActivity(intent)
        }

        startBtn.setOnClickListener {
            mGameView.setBackgroundResource(R.drawable.road_0)
            rootLayout.addView(mGameView)
            startBtn.visibility =View.GONE
            score.visibility = View.GONE

        }

    }

    override fun closeGame(mScore: Int) {
        score.text = "Score : $mScore"
        rootLayout.removeView(mGameView)
        startBtn.visibility = View.VISIBLE
        score.visibility = View.VISIBLE
    }

}