package com.example.moodtracker.data.repos

import androidx.lifecycle.LiveData
import com.example.moodtracker.data.database.dao.MoodDao
import com.example.moodtracker.models.Mood
import com.example.moodtracker.ui.MainActivity

//implementation for moodrepo
class MoodRzn(private val moodDao: MoodDao): MoodRepo{

    override val allMoods : LiveData<List<Mood>>
    //retrieves all moods objects from database
    get() = moodDao.getAllMoods()


    //suspend function until needed
    //updates selected mood in database when required
    override suspend fun selectMood(mood:Mood,  onSuccess: () -> Unit) {
        moodDao.selectMood(mood)
        onSuccess()
    }




}