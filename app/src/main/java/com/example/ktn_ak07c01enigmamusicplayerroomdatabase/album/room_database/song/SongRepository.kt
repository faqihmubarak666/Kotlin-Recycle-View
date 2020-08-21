package com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.room_database.song

import androidx.lifecycle.LiveData
import org.intellij.lang.annotations.JdkConstants

class SongRepository (private val songDao: SongDao){
    val allSong: LiveData<List<Song>> = songDao.getAllSong()

    fun createdSong(song: Song){
        songDao.createdSong(song)
    }

    fun detailSong(id: Int){
        songDao.getSongById(id)
    }
}