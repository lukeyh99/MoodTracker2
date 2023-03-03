package com.example.moodtracker.ui.fragments.selectMoodWindow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.moodtracker.models.Mood
import com.example.moodtracker.databinding.FragSelectMoodBinding
import com.example.moodtracker.R
import com.example.moodtracker.utils.*
import java.text.SimpleDateFormat
import java.util.*

/*
*/

class SelectMoodFrag : Fragment(){
    private lateinit var bind : FragSelectMoodBinding
    private lateinit var viewModel : SelectMoodViewModel

    override fun onCreateView( //inflate layout
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        bind = FragSelectMoodBinding.inflate(inflater, container, false)
        return bind.root
    }
//save instance of this state when the super function is called
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()//initalize it
    }

    private fun init() {//initalization function
        viewModel = ViewModelProvider(this).get(SelectMoodViewModel::class.java)


        val date = getCurrentDateTime()//put the date into a string
        val dateInString = date.toString("dd.MM.yyyy")

        bind.buttonSaveMood.setOnClickListener {
            val mood = when(bind.RadioGroupEmotions.checkedRadioButtonId) {
                R.id.HappyButton -> HAPPY//all the buttons that are used in select mood screen
                R.id.ContentButton-> CONTENT
                R.id.GlumButton -> GLUM
                R.id.SadButton -> SAD
                R.id.AngryButton -> ANGRY
                R.id.StressedButton -> STRESSED

                else -> HAPPY
            }
            val activity = when(bind.RadioGroupActivities.checkedRadioButtonId) {
                R.id.StudyButton -> STUDY//all the buttons that are used in select mood screen activities
                R.id.GamedButton -> GAMED
                R.id.SportButton -> SPORT
                R.id.SocialButton -> SOCIAL
                R.id.RelaxButton -> RELAX

                else -> RELAX
            }



            val moodDescription = bind.textAbFeelings.text.toString()//info about your mood you entered stores in mood description
            val moodItem = Mood(mood = mood, MoodText = moodDescription, date = dateInString , activity = activity)//creates mood object with properties set to corresponding variables and constants
            val activityItem = Mood(mood = mood, MoodText = moodDescription, date = dateInString , activity = activity)//creates new mood object
            viewModel.selectMood(moodItem , activityItem){}//updates selected mood object in the database
            Toast.makeText(requireContext(), "Updated mood added.", Toast.LENGTH_SHORT).show()//prompt for when you succesfully updated mood
            bind.textAbFeelings.text = null//clears text after update
            bind.RadioGroupEmotions.check(R.id.HappyButton)//sets button to happy if not clicked
            bind.RadioGroupActivities.check(R.id.RelaxButton)//sets button to relaxed if not clicked
        }




    }

    private fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
        val formatter = SimpleDateFormat(format, locale)//format the date
        return formatter.format(this)
    }

    private fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time//get the time and return it to the calendar
    }

}