package com.example.moodtracker.ui.fragments.calendarWindow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moodtracker.R
import com.example.moodtracker.adapters.MoodAdapt
import com.example.moodtracker.databinding.FragMoodCalendarBinding
import java.util.*

class CalendarFrag: Fragment() {
//bind calendar with its xml
    private lateinit var bind: FragMoodCalendarBinding
    private lateinit var viewModel: CalendarViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MoodAdapt

    override fun onCreateView(//inflate the layout
    inflater: LayoutInflater , container: ViewGroup?,
    savedInstanceState : Bundle?,
    ): View?{
        bind = FragMoodCalendarBinding.inflate(inflater , container , false)
        return bind.root
    }

    override fun onViewCreated(view : View , savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    private fun init() {//intialize the view model
        viewModel = ViewModelProvider(this).get(CalendarViewModel::class.java)
        adapter = MoodAdapt()//set adapter to fill data in UI component
        recyclerView = bind.reViewMoods//recycler view moods contains views corresponding to my data
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

//mood  list will  be accessed from the data base
        viewModel.getMoods().observe(viewLifecycleOwner, { moodList ->
            adapter.setList(moodList.asReversed())
        })

         bind.BackButton.setOnClickListener{
            findNavController().navigate(R.id.action_calendar_to_selectMood)
        }


    }
}