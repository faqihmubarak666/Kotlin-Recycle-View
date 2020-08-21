package com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.room_database.title

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.room_database.song.Song

@Dao
interface TitleDao {
    @Insert
    fun createdTile(title: Title)

    @Transaction
    @Query(value = "SELECT * FROM Song WHERE  id = :titleSongId")
    fun getAllTitle(titleSongId:Int): LiveData<SongPlaylist>

    @Query(value = "SELECT * FROM Title where id = :id")
    fun getTitleById(id: Int): Title

}