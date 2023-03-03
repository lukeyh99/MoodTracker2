package com.example.moodtracker.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moodtracker.data.database.dao.MoodDao
import com.example.moodtracker.models.Mood

@Database(entities = [Mood::class], version = 2)//defines the mood database
abstract class MoodDB :RoomDatabase()
{
    abstract fun getMoodDao() : MoodDao
//essentially static object tied to class but not instance of it
    companion object{
        private var database:MoodDB? = null

    @Synchronized // prevents thread interface and memory errors
    fun getInstance(context: Context) : MoodDB{
        return if (database == null)
        {//rebuild the data base from what it originally was if the database is empty
            database = Room.databaseBuilder(context,MoodDB::class.java,"mood_table.db")
                .fallbackToDestructiveMigration().build()//Allows Room to destructively recreate database tables
            database as MoodDB
        }
        else
        {
            database as MoodDB
        }
    }

    }
}

