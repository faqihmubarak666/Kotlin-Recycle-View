package com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.recycle_view

import android.content.Context
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
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.view_model.TitleViewModel

class SongRecycleAdapter(private val songList: List<Song>, val songViewModel: SongViewModel) :
    RecyclerView.Adapter<SongViewHolder>() {


    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.song_recycle_view, parent, false)
        context = parent.context
       return SongViewHolder(view, songViewModel)
    }

    override fun getItemCount(): Int {
        return songList.size
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.index = position
        holder.itemView.setOnClickListener(holder)
        holder.artist.text = songList[position].name
        holder.songTitle.text = songList[position].title
        var imageName = songList[position].image
        Glide.with(context).load(imageName).into(holder.imageSong)

    }
}

class SongViewHolder(v: View, val songViewModel: SongViewModel) : RecyclerView.ViewHolder(v),
    View.OnClickListener {

    var index: Int = 0
    val imageSong: ImageView = v.findViewById(R.id.image_song)
    val songTitle: TextView = v.findViewById(R.id.title_song)
    val artist: TextView = v.findViewById(R.id.artis_song)

    override fun onClick(v: View?) {
        when (v) {
            itemView -> {
                songViewModel.detailSongView(index)
                Toast.makeText(v.context, "${songTitle.text} your click", Toast.LENGTH_SHORT).show()
                itemView.findNavController()
                    .navigate(R.id.action_listSongFragment_to_detailSongFragment2)
            }
        }
    }
}
