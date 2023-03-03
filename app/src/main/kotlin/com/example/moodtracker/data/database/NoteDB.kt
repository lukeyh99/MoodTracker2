package com.example.moodtracker.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.moodtracker.data.database.dao.NotesDao
import com.example.moodtracker.models.Note

@Database(entities = [Note:: class], version = 3)//defines the note database
abstract class NoteDB : RoomDatabase() {
    abstract fun getNotesDao(): NotesDao//create function get Note Data access object
    companion object{
        private var database: NoteDB? = null

        @Synchronized// method will be protected from concurrent execution by multiple threads
        fun getInstance(context: Context): NoteDB
        {
            return if ( database == null){//first time get instance is called database is null so it creates new instance of NoteDB
                database = Room.databaseBuilder(context,
                NoteDB::class.java,
                "notes.db")
                    .fallbackToDestructiveMigration().build()//The fallbackToDestructiveMigration() method is called to ensure that the database is destroyed and re-created if a migration is not possible
                database as NoteDB
            }
            else
            {
                database as NoteDB
            }
        }
    }
}