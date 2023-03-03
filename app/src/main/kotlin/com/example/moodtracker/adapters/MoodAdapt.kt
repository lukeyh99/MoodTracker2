package com.example.moodtracker.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moodtracker.R
import com.example.moodtracker.databinding.LayoutOfMoodsBinding
import com.example.moodtracker.models.Mood
import com.example.moodtracker.utils.*
//bridge between the UI portion for mood and the data source for mood
//takes data and shows it on different view like list views
class MoodAdapt : RecyclerView.Adapter<MoodAdapt.MoodViewHolder>()
{//data displayed  in list form
    private var moodList: List<Mood> = emptyList()//start list as empty list until something is added
    class MoodViewHolder(val bind : LayoutOfMoodsBinding) : RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoodViewHolder {
        //inflate the layout for the mood list
        val bind = LayoutOfMoodsBinding.inflate(LayoutInflater.from(parent.context), parent ,false)
        return MoodViewHolder(bind)
    }
//bind ui to the correct positions in the layout
    override fun onBindViewHolder(holder: MoodViewHolder, position: Int) {
        val mood = moodList[position]
    holder.bind.apply{

            //bind each variable to the correct corresponding constant
            dateOfMood.text = mood.date
            textMood.text = mood.MoodText

            iconMood.setImageResource(when(mood.mood) {
                HAPPY -> R.drawable.happy
                CONTENT-> R.drawable.content
                GLUM -> R.drawable.glum
                SAD -> R.drawable.sad

                else -> R.drawable.happy
            })
        iconActivity.setImageResource(when(mood.activity) {
            RELAX -> R.drawable.relax
            GAMED-> R.drawable.gamed
            SPORT -> R.drawable.sport
            SOCIAL -> R.drawable.socialise
            STUDY -> R.drawable.study


            else -> R.drawable.relax
        })
        }
    }
    override fun getItemCount():Int = moodList.size//retrieve number of moods in the list
    fun setList(list : List<Mood>)
    {
        //data displayed in the UI
        moodList = list
        notifyDataSetChanged()
    }
}