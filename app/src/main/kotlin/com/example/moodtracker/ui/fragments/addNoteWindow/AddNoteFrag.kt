package com.example.moodtracker.ui.fragments.addNoteWindow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.moodtracker.R
import com.example.moodtracker.databinding.FragAddNoteBinding
import com.example.moodtracker.models.Note
import java.text.SimpleDateFormat
import java.util.*
//bind the add note fragment to its xml
class AddNoteFrag : Fragment(){
    private lateinit var bind: FragAddNoteBinding
    private lateinit var viewModel: AddNoteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,):View?{
        //inflate layout for specific fragment
        bind = FragAddNoteBinding.inflate(inflater, container , false)
        return bind.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {//initalise the view model for add note
        viewModel = ViewModelProvider(this).get(AddNoteViewModel::class.java)

        val date = getCurrentDateTime()
        val dateInString = date.toString("dd.MM.yyyy")
        val timeInString = date.toString("HH:mm")

        bind.textViewDate.text = dateInString
        bind.textViewTime.text = timeInString
//initialize the save mood button and where it should take you after
        bind.buttonSaveMood.setOnClickListener {
            val title = bind.editTextTitleOfNote.text.toString()
            val information = bind.editTextTextOfNote.text.toString()

            val note = Note(title = title, info = information , date = dateInString, time = timeInString)
            viewModel.insert(note){}
            findNavController().navigate(R.id.action_addNote_to_listOfNotes)
        }

        bind.btnBackAdd.setOnClickListener {
            findNavController().navigate(R.id.action_addNote_to_listOfNotes)
        }

    }
//turn date to string
    private fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }
//place time in calendar window
    private fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }


}