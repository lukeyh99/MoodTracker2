package com.example.moodtracker.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.moodtracker.models.Note
//object to access notes this function also doesnt need to be used all the time can access
//whenever its needed


@Dao
interface NotesDao {

    @Query("SELECT * FROM diary_table")
    fun retrieveAllNotes(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

}