package com.example.moodtracker.ui.fragments.homeWindow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.moodtracker.R
import com.example.moodtracker.databinding.FragHomeBinding

class HomeFrag :  Fragment(){
    private lateinit var bind : FragHomeBinding
    private lateinit var viewModel : HomeViewModel

    override fun onCreateView( //inflate layout
    inflater: LayoutInflater , container: ViewGroup?,
    savedInstanceState: Bundle?,): View? {
        //inflate layout for this fragment
        bind = FragHomeBinding.inflate(inflater , container , false)
        return bind.root

    }
    //save  instance of this state when super function is called

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        //make sure the state is saved incase the app crashes
        super.onViewCreated(view , savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        bind.Continue.setOnClickListener{
            findNavController().navigate(R.id.action_home_to_selectMood)
        }

    }
}