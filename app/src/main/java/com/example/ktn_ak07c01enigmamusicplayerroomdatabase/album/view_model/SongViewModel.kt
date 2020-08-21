package com.example.day10_recycle_view.language.viewmodel

import android.app.Application
import android.widget.TextView
import androidx.lifecycle.*
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.room_database.AppRoomDatabase
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.room_database.song.Song
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.room_database.song.SongRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SongViewModel(application: Application) : AndroidViewModel(application){
    private val repository: SongRepository
    val allSong: LiveData<List<Song>>
    val details: MutableMap<String, String> = mutableMapOf()


    init {
        val songDao = AppRoomDatabase.getDatabaseInstance(application).songDao()
        repository = SongRepository(songDao)
        allSong = repository.allSong
    }

    fun createdNewSong(song: Song){
        viewModelScope.launch(Dispatchers.IO){
            repository.createdSong(song)
        }
    }

    fun detailSongView(id: Int){
        viewModelScope.launch(Dispatchers.IO) {
            val song = repository.allSong.value!!.get(id)
            details.put("name", song.name)
            details.put("title", song.title)
            details.put("image", song.image)
            details.put("id", song.id.toString())
        }
    }
}
