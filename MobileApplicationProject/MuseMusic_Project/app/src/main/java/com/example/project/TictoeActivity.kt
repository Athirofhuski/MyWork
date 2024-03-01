package com.example.project

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog


class TictoeActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var x0: Button
    lateinit var x1: Button
    lateinit var x2: Button
    lateinit var x3: Button
    lateinit var x4: Button
    lateinit var x5: Button
    lateinit var x6: Button
    lateinit var x7: Button
    lateinit var x8: Button

    lateinit var tv: TextView
    var player1 = 0
    var player2 = 1
    var activePlayer = player1
    lateinit var filledPos: IntArray

    var gameActive = true

    var btn_tb    : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(MainActivity.currentTheme[MainActivity.themeIndex])
        setContentView(R.layout.activity_tictoe)

        filledPos = intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1)

        tv = findViewById(R.id.textView2)
        x0 = findViewById(R.id.x0)
        x1 = findViewById(R.id.x1)
        x2 = findViewById(R.id.x2)
        x3 = findViewById(R.id.x3)
        x4 = findViewById(R.id.x4)
        x5 = findViewById(R.id.x5)
        x6 = findViewById(R.id.x6)
        x7 = findViewById(R.id.x7)
        x8 = findViewById(R.id.x8)


        x0.setOnClickListener(this)
        x1.setOnClickListener(this)
        x2.setOnClickListener(this)
        x3.setOnClickListener(this)
        x4.setOnClickListener(this)
        x5.setOnClickListener(this)
        x6.setOnClickListener(this)
        x7.setOnClickListener(this)
        x8.setOnClickListener(this)

        btn_tb = findViewById(R.id.btn_tb1)
        btn_tb!!.setOnClickListener {
            var intent = Intent(this, Game::class.java)
            startActivity(intent)
        }

    }

    override fun onClick(v: View?) {

        if (!gameActive)
            return

        var btnClicked = findViewById<Button>(v!!.id)
        var clickedTag = Integer.parseInt(btnClicked.tag.toString())

        if (filledPos[clickedTag] != -1)
            return

        filledPos[clickedTag] = activePlayer

        if (activePlayer == player1) {
            btnClicked.setText("O")
            activePlayer = player2
            tv.setText("Player-2 Turn")
            btnClicked.setTextColor(Color.WHITE)
            btnClicked.backgroundTintList = getColorStateList(R.color.pastel_green)
        } else {
            btnClicked.setText("X")
            activePlayer = player1
            tv.setText("Player-1 Turn")
            btnClicked.setTextColor(Color.BLACK)
            btnClicked.backgroundTintList = getColorStateList(R.color.pastel_red)
        }

        checkForWin()
    }

    private fun checkForWin() {
        var winPos = arrayOf(
            intArrayOf(0, 1, 2),
            intArrayOf(3, 4, 5),
            intArrayOf(6, 7, 8),
            intArrayOf(0, 3, 6),
            intArrayOf(1, 4, 7),
            intArrayOf(2, 5, 8),
            intArrayOf(0, 4, 8),
            intArrayOf(2, 4, 6)
        )

        for (i in 0 until winPos.size) {
            var val0 = winPos[i][0]
            var val1 = winPos[i][1]
            var val2 = winPos[i][2]

            if (filledPos[val0] == filledPos[val1] && filledPos[val1] == filledPos[val2]) {
                if (filledPos[val0] != -1) {
                    gameActive = false
                    if (filledPos[val0] == player1) {
                        showMessage("Player-1 is Winner!")
                        //tv.setText("Player-1 is Winner!")
                    } else {
                        //tv.setText("Player-2 is Winner!")
                        showMessage("Player-2 is Winner!")
                    }
                    return
                }
            }
            //To Check for Draw
            var count = 0
            for (i in 0 until filledPos.size) {
                if (filledPos[i] == -1) {
                    count++
                }
            }
            if (count == 0) {
                showMessage("It's Draw.")
                return
            }

        }
    }

    private fun showMessage(s: String) {
        AlertDialog.Builder(this)
            .setMessage(s)
            .setTitle("Tic Tac Toe")
            .setPositiveButton("Restart Game", DialogInterface.OnClickListener { dialog, which ->
                restartGame()
            })
            .show()
    }

    private fun restartGame() {
        filledPos = intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1)
        activePlayer = player1
        gameActive = true
        tv.setText("Player-1 Turn")
        x0.setText("")
        x1.setText("")
        x2.setText("")
        x3.setText("")
        x4.setText("")
        x5.setText("")
        x6.setText("")
        x7.setText("")
        x8.setText("")
        x0.backgroundTintList = getColorStateList(R.color.bl_1)
        x1.backgroundTintList = getColorStateList(R.color.bl_1)
        x2.backgroundTintList = getColorStateList(R.color.bl_1)
        x3.backgroundTintList = getColorStateList(R.color.bl_1)
        x4.backgroundTintList = getColorStateList(R.color.bl_1)
        x5.backgroundTintList = getColorStateList(R.color.bl_1)
        x6.backgroundTintList = getColorStateList(R.color.bl_1)
        x7.backgroundTintList = getColorStateList(R.color.bl_1)
        x8.backgroundTintList = getColorStateList(R.color.bl_1)


    }
}