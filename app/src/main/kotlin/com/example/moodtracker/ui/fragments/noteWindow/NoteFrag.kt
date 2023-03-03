package com.example.moodtracker.ui.fragments.noteWindow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.moodtracker.R
import com.example.moodtracker.databinding.FragNoteBinding
import com.example.moodtracker.models.Note
import java.text.SimpleDateFormat
import java.util.*
import androidx.lifecycle.get
import com.example.moodtracker.utils.NOTE


class NoteFrag: Fragment() {
                    private lateinit var bind : FragNoteBinding
                    private lateinit var currentNote: Note
                    private lateinit var viewModel : NoteViewModel
                    val args: NoteFragArgs by navArgs()


                    override fun onCreateView(
                        inflater: LayoutInflater , container:ViewGroup?,
                        savedInstanceState: Bundle?,
                    ): View? {

                        //inflate the layout of the note screen
                        bind = FragNoteBinding.inflate(inflater , container , false)
                        return bind.root
                    }
                    //save instance created so it does not delete if the app crashes
                    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                        super.onViewCreated(view, savedInstanceState)
                        init()
                    }
    //initalise charachteristics of the note time and date
                    private fun init() {
                        viewModel = ViewModelProvider(this)[NoteViewModel::class.java]
                        val note = args.note
                        val date = getCurrentDateTime()
                        val dateAsString = date.toString("dd.MM.yyyy")
                        val timeAsString = date.toString("HH.mm")

                        bind.apply {//apply the charachetristics to the note
                            DiaryNote.append(note.info)
                            textViewDate.text = note.date
                            etTitle.append(note.title)
                            textViewTime.text = note.time
                            //button to save and update your mood
                            btnSaveDiaryEntry.setOnClickListener {
                                val title = etTitle.text.toString()
                                val information = DiaryNote.text.toString()
                                val noteUpdated = Note(
                                    id = args.note.id,
                                    title = title,
                                    info = information,
                                    date = dateAsString,
                                    time = timeAsString
                                )
                                viewModel.updateNote(noteUpdated)
                            }
                            // instantiate button to go back
                            BackButton.setOnClickListener{
                                findNavController().navigate(R.id.action_DiaryNote_to_listOfNotes)
                            }
                            //instantiate button to go back
                            DeleteButton.setOnClickListener{
                                viewModel.deleteNote(note)
                                findNavController().navigate(R.id.action_DiaryNote_to_listOfNotes)
                            }
                        }

                    }
                    //gets current date that is on the machine
                    //and puts it into simple date format
                    private fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String{
                            val formatter = SimpleDateFormat(format,locale)
                    return formatter.format(this)


                    }
                private fun getCurrentDateTime(): Date {
                    return Calendar.getInstance().time
                }
}