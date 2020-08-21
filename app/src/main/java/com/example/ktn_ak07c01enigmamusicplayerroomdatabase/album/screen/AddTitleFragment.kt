package com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.R
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.room_database.title.Title
import com.example.ktn_ak07c01enigmamusicplayerroomdatabase.album.view_model.TitleViewModel
import kotlinx.android.synthetic.main.fragment_add_title.*


class AddTitleFragment : Fragment(), View.OnClickListener {

    val titleViewModel by activityViewModels<TitleViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_title, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        save_btn_detail.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val id = arguments?.getString("id")!!.toInt()
        when(v){
            save_btn_detail -> {
                val title = input_title_detail.text.toString()
                val duration = input_duration_detail.text.toString()
                titleViewModel.createdNewTitle(Title(titleDetail = title, duration = duration, titleSongId = id))
                Toast.makeText(v?.context, "Add Title Success", Toast.LENGTH_SHORT).show()
                activity?.onBackPressed()
            }
        }
    }
}