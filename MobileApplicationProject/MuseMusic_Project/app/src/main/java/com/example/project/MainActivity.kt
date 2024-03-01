package com.example.project


import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.*
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project.databinding.ActivityMainBinding
import com.example.project.model.Uicr
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_main.*

import java.io.File
import java.io.IOException


class MainActivity : AppCompatActivity() {
    //Creating Binding Object
    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var musicAdapter: MusicAdapter

//    var play1 : ImageButton? = null

    companion object{
        lateinit var MusicListMA : ArrayList<Music>

        var themeIndex: Int = 0
        val currentTheme = arrayOf(R.style.coolPink, R.style.coolBlue, R.style.coolPurple, R.style.coolGreen, R.style.coolBlack)
        val currentThemeNav = arrayOf(R.style.coolPinkNav, R.style.coolBlueNav, R.style.coolPurpleNav, R.style.coolGreenNav, R.style.coolBlackNav)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val themeEditor = getSharedPreferences("THEMES", MODE_PRIVATE)
        themeIndex = themeEditor.getInt("themeIndex", 0)
        setTheme(currentThemeNav[themeIndex])
        initializeLayout()

        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navHome -> startActivity(Intent(this@MainActivity, MainActivity::class.java))
                R.id.navShop -> startActivity(Intent(this@MainActivity, Uicr::class.java))
                R.id.navGames -> startActivity(Intent(this@MainActivity, Game::class.java))
                R.id.navSettings -> startActivity(Intent(this@MainActivity, Result::class.java))
            }
            true
        }

        val mediaPlayer1 = MediaPlayer.create(this,R.raw.slchld1)
        val play1 = findViewById<View>(R.id.play1)

        play1!!.setOnClickListener {
            if (!mediaPlayer1.isPlaying){
                mediaPlayer1.start()
            } else {
                mediaPlayer1.pause()
            }
        }

        val mediaPlayer2 = MediaPlayer.create(this,R.raw.thai1)
        val play2 = findViewById<View>(R.id.play2)

        play2!!.setOnClickListener {
            if (!mediaPlayer2.isPlaying){
                mediaPlayer2.start()
            } else {
                mediaPlayer2.pause()
            }
        }

        val mediaPlayer3 = MediaPlayer.create(this,R.raw.slchld2)
        val play3 = findViewById<View>(R.id.play3)

        play3!!.setOnClickListener {
            if (!mediaPlayer3.isPlaying){
                mediaPlayer3.start()
            } else {
                mediaPlayer3.pause()
            }
        }

        val mediaPlayer4 = MediaPlayer.create(this,R.raw.slchld3)
        val play4 = findViewById<View>(R.id.play4)

        play4!!.setOnClickListener {
            if (!mediaPlayer4.isPlaying){
                mediaPlayer4.start()
            } else {
                mediaPlayer4.pause()
            }
        }

        val mediaPlayer5 = MediaPlayer.create(this,R.raw.thai2)
        val play5 = findViewById<View>(R.id.play5)

        play5!!.setOnClickListener {
            if (!mediaPlayer5.isPlaying){
                mediaPlayer5.start()
            } else {
                mediaPlayer5.pause()
            }
        }

        val mediaPlayer6 = MediaPlayer.create(this,R.raw.hybs)
        val play6 = findViewById<View>(R.id.play6)

        play6!!.setOnClickListener {
            if (!mediaPlayer6.isPlaying){
                mediaPlayer6.start()
            } else {
                mediaPlayer6.pause()
            }
        }

        val mediaPlayer7 = MediaPlayer.create(this,R.raw.nj1)
        val play7 = findViewById<View>(R.id.play7)

        play7!!.setOnClickListener {
            if (!mediaPlayer7.isPlaying){
                mediaPlayer7.start()
            } else {
                mediaPlayer7.pause()
            }
        }

        val mediaPlayer8 = MediaPlayer.create(this,R.raw.nj2)
        val play8 = findViewById<View>(R.id.play8)

        play8!!.setOnClickListener {
            if (!mediaPlayer8.isPlaying){
                mediaPlayer8.start()
            } else {
                mediaPlayer8.pause()
            }
        }

        val mediaPlayer9 = MediaPlayer.create(this,R.raw.nj3)
        val play9 = findViewById<View>(R.id.play9)

        play9!!.setOnClickListener {
            if (!mediaPlayer9.isPlaying){
                mediaPlayer9.start()
            } else {
                mediaPlayer9.pause()
            }
        }

        val mediaPlayer10 = MediaPlayer.create(this,R.raw.nj4)
        val play10 = findViewById<View>(R.id.play10)

        play10!!.setOnClickListener {
            if (!mediaPlayer10.isPlaying){
                mediaPlayer10.start()
            } else {
                mediaPlayer10.pause()
            }
        }

        val mediaPlayer11 = MediaPlayer.create(this,R.raw.twice)
        val play11 = findViewById<View>(R.id.play11)

        play11!!.setOnClickListener {
            if (!mediaPlayer11.isPlaying){
                mediaPlayer11.start()
            } else {
                mediaPlayer11.pause()
            }
        }
    }

    //For requesting permission
    private fun requestRuntimePermission() {
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
                13
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 13) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
            else
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    5
                )
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }

    @RequiresApi(Build.VERSION_CODES.R)
    @SuppressLint("SetTextI18n")
    private fun initializeLayout() {
        requestRuntimePermission()
        //Initializing Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //for nav drawer
        toggle = ActionBarDrawerToggle(this, binding.root, R.string.open, R.string.close)
        binding.root.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val musicList = ArrayList<String>()
        MusicListMA = getAllAudio()
        binding.musicRV.setHasFixedSize(true)
        binding.musicRV.setItemViewCacheSize(13)
        binding.musicRV.layoutManager = LinearLayoutManager(this@MainActivity)
        musicAdapter = MusicAdapter(this@MainActivity, MusicListMA)
        binding.musicRV.adapter = musicAdapter
   //     binding.totalSongs.text = "Total Songs : " + musicAdapter.itemCount

    }
    @SuppressLint("Recycle", "Range")
    @RequiresApi(Build.VERSION_CODES.R)

    private fun getAllAudio(): ArrayList<Music>{
        val tempList = ArrayList<Music>()
        val selection = Audio.Media.IS_MUSIC + " != 0"
        val projection = arrayOf(Audio.Media._ID, Audio.Media.TITLE, Audio.Media.ALBUM,
            Audio.Media.ARTIST, Audio.Media.DURATION, Audio.Media.DATE_ADDED,
            Audio.Media.DATA)
        val cursor = this.contentResolver.query(
            MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, projection,selection,null,
            MediaStore.Audio.Media.DATE_ADDED + " DESC",null )
        if(cursor != null){
            if(cursor.moveToFirst())
                do{
                    val titleC = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE))
                    val idC = cursor.getString(cursor.getColumnIndex(Audio.Media._ID))
                    val albumC = cursor.getString(cursor.getColumnIndex(Audio.Media.ALBUM))
                    val artistC = cursor.getString(cursor.getColumnIndex(Audio.Media.ARTIST))
                    val pathC = cursor.getString(cursor.getColumnIndex(Audio.Media.DATA))
                    val durationC = cursor.getLong(cursor.getColumnIndex(Audio.Media.TITLE))
                    val music = Music(id = idC, title = titleC, album = albumC, artist = artistC, path = pathC, duration = durationC)
                    val file = File(music.path)
                    if(file.exists())
                        tempList.add(music)
                }while (cursor.moveToNext())
            cursor.close()
        }
        return tempList
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_view_menu, menu)
        val searchView = menu?.findItem(R.id.searchView)?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean = true
            override fun onQueryTextChange(newText: String?): Boolean {
                Toast.makeText(this@MainActivity, newText.toString(), Toast.LENGTH_SHORT).show()
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

}


