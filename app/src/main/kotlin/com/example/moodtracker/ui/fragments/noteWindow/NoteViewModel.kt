package com.example.moodtracker.ui.fragments.noteWindow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moodtracker.models.Note
import com.example.moodtracker.utils.note_repos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel() : ViewModel() {
//viewmodelscope is needed because any coroutine launched in this scope is cleared if the model is cleared
    fun updateNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        note_repos.updateNote(note){}
    }


    fun deleteNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        note_repos.deleteNote(note){}
    }
}