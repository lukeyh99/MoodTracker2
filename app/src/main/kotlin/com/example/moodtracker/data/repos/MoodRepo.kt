package com.example.moodtracker.data.repos

import android.app.Activity
import androidx.lifecycle.LiveData
import com.example.moodtracker.models.Mood

interface MoodRepo {
     val allMoods: LiveData<List<Mood>>//returns live data object containing moods

     suspend fun selectMood(mood: Mood,onSuccess:() -> Unit)//takes mood and lambda onSuccess in order to update select mood object

}