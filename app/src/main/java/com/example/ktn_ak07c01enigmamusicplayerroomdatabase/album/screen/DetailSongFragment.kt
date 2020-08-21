package com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.day10_recycle_view.language.viewmodel.SongViewModel
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.R
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.recycle_view.TitleReycleAdapter
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.view_model.TitleViewModel
import kotlinx.android.synthetic.main.fragment_detail_song.*


class DetailSongFragment : Fragment(), View.OnClickListener {

    val songViewModel by activityViewModels<SongViewModel>()
    val titleViewModel by activityViewModels<TitleViewModel>()
    lateinit var titleReycleAdapter: TitleReycleAdapter
    lateinit var navController: NavController

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
        Glide.with(this).load(songViewModel.details["image"]).into(image_detail)

        titleRecycleView.layoutManager = LinearLayoutManager(this.context)


        titleViewModel.allTitle(songViewModel.details["id"]!!.toInt()).observe(viewLifecycleOwner, Observer {
            titleReycleAdapter = TitleReycleAdapter(it)
            titleRecycleView.adapter = titleReycleAdapter
        })


        floatingActionButtonDetail.setOnClickListener(this)
        navController = Navigation.findNavController(view)
    }

    override fun onClick(v: View?) {
        when(v){
            floatingActionButtonDetail -> {navController.navigate(R.id.action_detailSongFragment_to_addTitleFragment, bundleOf("id" to songViewModel.details["id"]))}
        }
    }

}