package com.example.moodtracker.ui.fragments.noteListWindow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moodtracker.models.Note
import com.example.moodtracker.utils.note_repos

class NoteListViewModel(): ViewModel() {

    fun getAllNotes() : LiveData<List<Note>> = note_repos.allNotes


}