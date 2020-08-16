package com.example.ktn_ak05c01recyclerviewdelete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.day10_recycle_view.language.viewmodel.LanguageVieModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CustomClickListener {

    val languageViewModel: LanguageVieModel by viewModels<LanguageVieModel>()
    lateinit var languageRecycleAdapter: LanguageRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        language_recycle_view.layoutManager = LinearLayoutManager(this)

        languageRecycleAdapter = LanguageRecycleAdapter(languageViewModel.languageLiveData.value!!)
        languageRecycleAdapter.listener = this

        language_recycle_view.adapter = languageRecycleAdapter

        languageViewModel.languageLiveData.observe(this, Observer {
            languageRecycleAdapter.notifyDataSetChanged()
        })
    }

    fun addLanguage(view: View) {
        val languageName = language_name_input.text.toString()
        languageViewModel.addLanguage(languageName)
    }

    override fun onItemClicked(view: View, language: String) {
        Toast.makeText(this, "$language", Toast.LENGTH_SHORT).show()
    }

    override fun onItemClicked(view: View, index: Int) {
        Toast.makeText(this, "$index Delete Succesful", Toast.LENGTH_SHORT).show()
        languageViewModel.removeLanguage(index)
    }
}
