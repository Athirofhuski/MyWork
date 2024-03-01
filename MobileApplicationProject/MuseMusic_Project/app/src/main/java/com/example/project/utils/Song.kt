package com.example.project.utils

class Song {
    var songName: String? = null
    var songUrl: String? = null

    constructor() {}
    constructor(songName: String?, songUrl: String?) {
        this.songName = songName
        this.songUrl = songUrl
    }
}