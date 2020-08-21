package com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.room_database.song

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Song(
    @PrimaryKey(autoGenerate = true) @ColumnInfo var id: Int = 0,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "image") var image: String
)