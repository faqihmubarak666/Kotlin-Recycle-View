package com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.room_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.room_database.song.Song
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.room_database.song.SongDao
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.room_database.title.Title
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.room_database.title.TitleDao

@Database(entities =  arrayOf(Song::class, Title::class), version = 3, exportSchema = false)
public abstract class  AppRoomDatabase: RoomDatabase(){
    abstract fun songDao(): SongDao
    abstract fun  titleDao():TitleDao

    companion object{
        private  var DATABASE_INSTANCE : AppRoomDatabase? = null

        fun getDatabaseInstance(context: Context): AppRoomDatabase{
            if (DATABASE_INSTANCE != null){
                return  DATABASE_INSTANCE as AppRoomDatabase
            }
            DATABASE_INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                AppRoomDatabase::class.java,
                "spotify_database"
            ).fallbackToDestructiveMigration().build()
            return DATABASE_INSTANCE as AppRoomDatabase
        }
    }
}