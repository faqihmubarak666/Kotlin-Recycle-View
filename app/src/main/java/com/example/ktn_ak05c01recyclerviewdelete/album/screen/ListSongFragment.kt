package com.example.ktn_ak05c01recyclerviewdelete.album.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.day10_recycle_view.language.viewmodel.SongViewModel
import com.example.ktn_ak05c01recyclerviewdelete.R
import com.example.ktn_ak05c01recyclerviewdelete.SongRecycleAdapter
import kotlinx.android.synthetic.main.fragment_list_song.*


class ListSongFragment : Fragment(), View.OnClickListener {

    val  songViewModel by activityViewModels<SongViewModel>()
    lateinit var adapter: SongRecycleAdapter
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_song, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        songRecycleView.layoutManager = LinearLayoutManager(this.context)
        adapter = SongRecycleAdapter(songViewModel)
        songRecycleView.adapter = adapter

        songViewModel.songData.observe(viewLifecycleOwner, Observer { adapter.notifyDataSetChanged() })

        floatingActionButton.setOnClickListener(this)

        navController = Navigation.findNavController(view)
    }

    override fun onClick(v: View?) {
        when(v){
            floatingActionButton -> {navController.navigate(R.id.action_listSongFragment_to_addSongFragment2)}
        }
    }



}