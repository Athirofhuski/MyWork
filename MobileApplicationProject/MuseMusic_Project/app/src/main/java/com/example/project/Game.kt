package com.example.project

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.project.databinding.ActivityGameBinding

class Game : AppCompatActivity() {

    var tictoe_btn: Button? = null
    var hangman_btn: Button? = null
    var racing_btn: Button? = null
    var sg_p    : ImageButton? = null
    var hg_p    : ImageButton? = null
    var gg_p    : ImageButton? = null
    var seg_p    : ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(MainActivity.currentTheme[MainActivity.themeIndex])
        setContentView(R.layout.activity_game)

        /////////// Find button


        tictoe_btn = findViewById(R.id.tictoe_btn)

        hangman_btn = findViewById(R.id.hanngman_btn)

        racing_btn = findViewById(R.id.racing_btn)

        sg_p = findViewById(R.id.sg_p)
        hg_p = findViewById(R.id.hg_p)
        gg_p = findViewById(R.id.gg_p)
        seg_p = findViewById(R.id.seg_p)

        // เชื่อมหน้า

        tictoe_btn!!.setOnClickListener {
            startActivity(Intent(this@Game, TictoeActivity::class.java))
        }
        hangman_btn!!.setOnClickListener {
            startActivity(Intent(this@Game, HangmanGameActivity::class.java))
        }

        racing_btn!!.setOnClickListener {
            startActivity(Intent(this@Game, RacingActivity::class.java))
        }

        sg_p!!.setOnClickListener {
            var intent = Intent(this, Shop::class.java)
            startActivity(intent)
        }

        hg_p!!.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        gg_p!!.setOnClickListener {
            var intent = Intent(this, Game::class.java)
            startActivity(intent)
        }

        seg_p!!.setOnClickListener {
            var intent = Intent(this, Result::class.java)
            startActivity(intent)
        }

    }
}