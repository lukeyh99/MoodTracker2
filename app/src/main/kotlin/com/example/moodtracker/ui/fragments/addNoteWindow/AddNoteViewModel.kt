package com.example.moodtracker.ui.fragments.addNoteWindow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moodtracker.models.Note
import com.example.moodtracker.utils.note_repos
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel :ViewModel() {// model to manage data on the fragment in question
    //adds notes to the  database
    fun insert(note: Note, onSuccess:() -> Unit) = viewModelScope.launch(Dispatchers.IO)//performs all the data operations
     {
        //call function from the function repository for notes
        note_repos.insertNote(note){}
    }
}