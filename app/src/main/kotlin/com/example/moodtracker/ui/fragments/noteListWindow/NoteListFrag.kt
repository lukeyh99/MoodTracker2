package com.example.moodtracker.ui.fragments.noteListWindow

import com.example.moodtracker.R
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moodtracker.adapters.DiaryAdapt
import com.example.moodtracker.databinding.FragListOfNotesBinding
import com.example.moodtracker.utils.NOTE
import java.util.*



class NoteListFrag : Fragment() {
    //bind the list notes frag
    private lateinit var bind: FragListOfNotesBinding
    private lateinit var viewModel: NoteListViewModel
    private lateinit var adapter: DiaryAdapt
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,container: ViewGroup?,//instantiates xml file into its relevant view
        savedInstanceState: Bundle?
    ): View? {//inflate this layout
        bind = FragListOfNotesBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {//initialise subclass once they know their hierarchy
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    private fun init() {
        viewModel = ViewModelProvider(this).get(NoteListViewModel::class.java)//create view models and return them
        adapter = DiaryAdapt()
        recyclerView = bind.reViewNotes
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)


        viewModel.getAllNotes().observe(viewLifecycleOwner, { listOfNotes ->
            adapter.setList(listOfNotes.asReversed())
            Log.d("init", "${listOfNotes}")
        })

        bind.addFab.setOnClickListener {//adds floating action button (Fab)
            findNavController().navigate(R.id.action_listOfNotes_to_addNote)
        }


        adapter.setOnItemClickListener {
            val bundle = Bundle()
            bundle.putSerializable(NOTE, it)
            findNavController().navigate(
                R.id.action_listOfNotes_to_DiaryNote,
                bundle
            )
        }

    }
}