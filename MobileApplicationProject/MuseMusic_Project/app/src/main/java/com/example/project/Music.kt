package com.example.project

import com.example.project.databinding.ActivityMainBinding
import java.security.cert.CertPath
import java.time.Duration
import kotlin.system.exitProcess

data class Music (val id:String, val title:String, val album:String, val artist:String, val duration: Long = 0, val path: String)


