package com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.room_database.title

import androidx.room.*
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.room_database.song.Song

@Entity
class Title(
    @PrimaryKey(autoGenerate = true) @ColumnInfo var id: Int = 0,
    @ColumnInfo(name ="titleSongId") var titleSongId: Int,
    @ColumnInfo(name = "titleDetail") var titleDetail: String,
    @ColumnInfo(name = "duration") var duration: String
)

class SongPlaylist(
    @Embedded
    val song: Song,
    @Relation(
        parentColumn = "id",
        entityColumn = "titleSongId"
    )
    val songPlaylist: List<Title>
)