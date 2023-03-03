package com.example.moodtracker.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
//creating the sql table in the database for the mood section
@Entity(tableName = "mood_table")//name of table
class Mood (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,//random number for primary key
    @ColumnInfo val mood: String,//what was the mood
    @ColumnInfo val activity: String,//what was the activity
    @ColumnInfo val MoodText: String,//the mood description
    @ColumnInfo val date: String//date mood was taken
)