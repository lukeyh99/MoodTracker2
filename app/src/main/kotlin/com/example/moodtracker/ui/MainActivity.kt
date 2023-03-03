package com.example.moodtracker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.moodtracker.R
import com.example.moodtracker.data.database.MoodDB
import com.example.moodtracker.databinding.ActivityMainBinding
import com.example.moodtracker.data.database.NoteDB
import com.example.moodtracker.data.repos.MoodRzn
import com.example.moodtracker.data.repos.NoteRzn
import com.example.moodtracker.utils.mood_repos
import com.example.moodtracker.utils.note_repos


class MainActivity : AppCompatActivity() {
    //variables that will be initalised later
    private lateinit var bind :  ActivityMainBinding
    lateinit var navController : NavController//move between different windows in the app
//calls the method in the superclass and saved InstanceState of the activity if any thing damage the activity so its saved in instanceState so when reload the activity it will be the same before
    override fun onCreate(savedInstanceState: Bundle?) {//initalise the fragments for you
        //call the super class to  initialise properties of the class
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)//instantiates layout xml file into the view object
        setContentView(bind.root) //set the view of the root layout with bind

        val navHostFrag = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment//give orders to fragment manager
        navController = navHostFrag.navController

        val moodDao = MoodDB.getInstance(this).getMoodDao()//mood data access object that retrieves instance of mood
        mood_repos = MoodRzn(moodDao)
        val noteDao = NoteDB.getInstance(this).getNotesDao()//note data access object that retrieves instance of mood
        note_repos = NoteRzn(noteDao)


        bind.bottomNavigationView.setupWithNavController(navController)


    }

}