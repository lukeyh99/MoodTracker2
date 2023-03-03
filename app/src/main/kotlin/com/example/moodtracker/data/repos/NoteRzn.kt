package com.example.moodtracker.data.repos

import androidx.lifecycle.LiveData
import com.example.moodtracker.data.database.dao.NotesDao
import com.example.moodtracker.models.Note

class NoteRzn(private val notesDao: NotesDao) : NoteRepo {

    override val allNotes : LiveData<List<Note>>
    get() = notesDao.retrieveAllNotes()
//updates each object the functions acting on when requried to act
    override suspend fun insertNote(note : Note, onSuccess: () -> Unit)
    {
        notesDao.insertNote(note)
        onSuccess()
    }
    override suspend fun updateNote(note: Note, onSuccess: () -> Unit)
    {
        notesDao.updateNote(note)
        onSuccess()
    }
    override suspend fun deleteNote(note: Note, onSuccess: () -> Unit)
    {
        notesDao.deleteNote(note)
        onSuccess()
    }
}