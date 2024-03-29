package com.example.project

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.project.databinding.ActivityThemeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlin.system.exitProcess

class ThemeActivity : AppCompatActivity() {
    lateinit var binding: ActivityThemeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(MainActivity.currentThemeNav[MainActivity.themeIndex])
        binding = ActivityThemeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "Set Theme"
        when(MainActivity.themeIndex){
            0 -> binding.coolPinkTheme.setBackgroundColor(Color.YELLOW)
            1 -> binding.coolBlueTheme.setBackgroundColor(Color.YELLOW)
            2 -> binding.coolPurpleTheme.setBackgroundColor(Color.YELLOW)
            3 -> binding.coolGreenTheme.setBackgroundColor(Color.YELLOW)
            4 -> binding.coolBlackTheme.setBackgroundColor(Color.YELLOW)

        }
        binding.coolPinkTheme.setOnClickListener{ saveTheme(0) }
        binding.coolBlueTheme.setOnClickListener{ saveTheme(1) }
        binding.coolPurpleTheme.setOnClickListener{ saveTheme(2) }
        binding.coolGreenTheme.setOnClickListener{ saveTheme(3) }
        binding.coolBlackTheme.setOnClickListener{ saveTheme(4) }
        binding.versionName.text = setVersionDetails()
    }

    private fun saveTheme(index: Int){
        if (MainActivity.themeIndex != index){
            val editor = getSharedPreferences("THEMES", MODE_PRIVATE).edit()
            editor.putInt("themeIndex", index)
            editor.apply()
            val builder = MaterialAlertDialogBuilder(this)
            builder.setTitle("Applt Theme")
                .setMessage("Do you want to apply theme?")
                .setPositiveButton("Yes") { _, _ ->
                    val editor = getSharedPreferences("THEMES", MODE_PRIVATE).edit()
                    editor.putInt("themeIndex", index)
                    editor.apply()
                    exitApplication()
                }
                .setNegativeButton("No"){dialog, _ ->
                    dialog.dismiss()
            }
            val customDialog = builder.create()
            customDialog.show()
            customDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.RED)
            customDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.RED)
        }
    }
    private fun setVersionDetails():String{
        return "Version Name: ${BuildConfig.VERSION_NAME}"
    }

    fun exitApplication(){
        exitProcess(1)
    }
}