package com.example.moodtracker.ui.fragments.calendarWindow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moodtracker.models.Mood
import com.example.moodtracker.utils.mood_repos


//view model for the calendar window of the app
class CalendarViewModel : ViewModel() {//observable data class holder
    fun getMoods() : LiveData<List<Mood>> = mood_repos.allMoods
}