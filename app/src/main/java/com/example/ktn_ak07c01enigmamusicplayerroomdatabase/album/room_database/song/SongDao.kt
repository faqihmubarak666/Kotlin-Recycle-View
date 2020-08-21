package com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.room_database.song

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SongDao{
    @Insert
    fun createdSong(song: Song)

    @Query(value = "SELECT * FROM Song")
    fun getAllSong(): LiveData<List<Song>>

    @Query(value = "SELECT * FROM Song where id = :id")
    fun getSongById(id: Int): Song
}