package com.example.moodtracker.data.database.dao

import android.app.Activity
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moodtracker.models.Mood

@Dao
interface MoodDao {
    //sql commands to access the mood database
    //simple command to get all the moods from the current database
    @Query("SELECT * FROM mood_table")
     fun getAllMoods() : LiveData<List<Mood>>

    //make suspend function so that it can be paused and resumed whenever you want
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun selectMood(mood: Mood)
//call the function whenever its needed
    //i.e you dont always need this function but can call when its needed
}