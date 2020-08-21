package com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.room_database.title

import androidx.lifecycle.LiveData
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.room_database.song.Song
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.room_database.song.SongDao

class TitleRepository (private val titleDao: TitleDao){

    fun allTitle(titleSongId:Int) = titleDao.getAllTitle(titleSongId)

    fun createdTitle(title: Title){
        titleDao.createdTile(title)
    }
}