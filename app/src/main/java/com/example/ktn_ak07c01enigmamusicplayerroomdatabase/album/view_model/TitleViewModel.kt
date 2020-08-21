package com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.room_database.AppRoomDatabase
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.room_database.song.Song
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.room_database.song.SongRepository
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.room_database.title.Title
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.room_database.title.TitleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TitleViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: TitleRepository

    init {
        val titleDao = AppRoomDatabase.getDatabaseInstance(application).titleDao()
        repository = TitleRepository(titleDao)
    }

    fun createdNewTitle(title: Title) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.createdTitle(title)
        }
    }

    fun allTitle(titleSongId: Int) = repository.allTitle(titleSongId)

}