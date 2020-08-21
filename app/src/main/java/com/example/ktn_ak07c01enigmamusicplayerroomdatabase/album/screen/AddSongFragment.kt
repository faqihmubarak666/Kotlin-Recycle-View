package com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.day10_recycle_view.language.viewmodel.SongViewModel
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.R
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.room_database.song.Song
import kotlinx.android.synthetic.main.fragment_add_song.*


class AddSongFragment : Fragment(), View.OnClickListener {

    val songViewModel by activityViewModels<SongViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_song, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        save_btn.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            save_btn -> {
                val name = input_name.text.toString()
                val title = input_title.text.toString()
                val image = input_image.text.toString()
                songViewModel.createdNewSong(Song(name = name, title = title, image = image))
                Toast.makeText(v?.context, "Add Data Success", Toast.LENGTH_SHORT).show()
                activity?.onBackPressed()
            }
        }
    }
}