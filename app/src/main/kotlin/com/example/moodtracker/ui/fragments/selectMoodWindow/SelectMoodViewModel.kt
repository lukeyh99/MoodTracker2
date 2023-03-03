package com.example.moodtracker.ui.fragments.selectMoodWindow

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.moodtracker.models.Mood
import com.example.moodtracker.ui.MainActivity
import com.example.moodtracker.utils.mood_repos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SelectMoodViewModel(application: Application): AndroidViewModel(application) {

    private val context = application//highest layer of the application

    fun selectMood(mood: Mood,activity: Mood ,  onSuccess:() -> Unit) = viewModelScope.launch(Dispatchers.IO){
        mood_repos.selectMood(mood){}
    }

}