package com.example.ktn_ak05c01recyclerviewdelete.album.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.day10_recycle_view.language.viewmodel.SongViewModel
import com.example.ktn_ak05c01recyclerviewdelete.R
import com.example.ktn_ak05c01recyclerviewdelete.album.utils.ConvertBitmap
import kotlinx.android.synthetic.main.fragment_detail_song.*


class DetailSongFragment : Fragment() {

    val songViewModel by activityViewModels<SongViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_song, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title_detail.text = songViewModel.details["title"]
        ConvertBitmap(image_detail).execute(songViewModel.details["image"])
    }

}