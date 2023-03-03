package com.example.moodtracker.data.repos

import androidx.lifecycle.LiveData
import com.example.moodtracker.models.Note

interface NoteRepo {
    //list that contains all the notes that have been entered
    val allNotes : LiveData<List<Note>>
//creates functions that may be needed in future note dao
    suspend fun  insertNote(note: Note, onSuccess: () -> Unit)

    suspend fun updateNote(note: Note, onSuccess: () -> Unit)

    suspend fun deleteNote(note: Note, onSuccess: () -> Unit)



}