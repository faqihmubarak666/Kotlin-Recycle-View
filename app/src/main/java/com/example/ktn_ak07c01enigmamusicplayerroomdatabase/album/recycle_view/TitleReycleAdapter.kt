package com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.recycle_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.day10_recycle_view.language.viewmodel.SongViewModel
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.R
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.room_database.song.Song
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.room_database.title.SongPlaylist
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.room_database.title.Title


class TitleReycleAdapter(private val titleList: SongPlaylist) :
    RecyclerView.Adapter<TitleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.title_recycle_view, parent, false)
        return TitleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return titleList.songPlaylist.size
    }

    override fun onBindViewHolder(holder: TitleViewHolder, position: Int) {
        holder.titleSongDetail.text = titleList.songPlaylist[position].titleDetail
        holder.timeSongDetail.text = titleList.songPlaylist[position].duration
        holder.playSong.setOnClickListener {
            if (holder.playSong.tag == null) {
                holder.playSong.setImageResource(R.drawable.ic_baseline_pause_24)
                holder.playSong.tag = 1
            } else {
                holder.playSong.setImageResource(R.drawable.ic_baseline_play_arrow_24)
                holder.playSong.tag = null
            }
        }
    }
}

class TitleViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val titleSongDetail: TextView = v.findViewById<TextView>(R.id.title_song_detail)
    val timeSongDetail: TextView = v.findViewById<TextView>(R.id.time_song_detail)
    val playSong: ImageView = v.findViewById<ImageView>(R.id.playSongButton)
}


