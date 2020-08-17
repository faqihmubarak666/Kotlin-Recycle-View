package com.example.day10_recycle_view.language.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.FieldPosition

class LanguageVieModel : ViewModel() {
    val languageList: MutableList<String> = mutableListOf<String>(
        "Golang",
        "React"
    )

    val languageLiveData: MutableLiveData<MutableList<String>> = MutableLiveData(languageList)

    fun addLanguage(name: String) {
        languageList.add(name)
        languageLiveData.value = languageList
    }

    fun removeLanguage(position: Int) {
        languageList.removeAt(position)
        languageLiveData.value = languageList
    }
}