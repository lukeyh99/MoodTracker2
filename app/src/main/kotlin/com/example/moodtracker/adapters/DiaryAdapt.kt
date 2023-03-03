package com.example.moodtracker.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moodtracker.databinding.NoteLayoutBinding
import com.example.moodtracker.models.Note


//adapter is the link between the ui and the source for the data
class DiaryAdapt:RecyclerView.Adapter<DiaryAdapt.DiaryScreen>() {
    //create empty list for notes to be entered into
    private var listOfNotes:List<Note> = emptyList()
//bind the diary screem the to the view
    class DiaryScreen(
        val bind: NoteLayoutBinding
    ) :RecyclerView.ViewHolder(bind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiaryScreen {
        val bind = NoteLayoutBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return DiaryScreen(bind)
        //inflate the layout
    }
    //convert the data to list of notes
    override fun onBindViewHolder(holder: DiaryScreen, position: Int) {
        val note = listOfNotes[position]
        holder.bind.textViewTitle.text = note.title
        holder.bind.textViewDescription.text = note.info

        holder.itemView.setOnClickListener {
            onItemClickListener?.let { it(note) }
        }
    }
//get number of note entrys
    override fun getItemCount(): Int = listOfNotes.size
//ignore specified warnings
    //if the data changes ignore
    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Note>) {
        listOfNotes = list
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: (Note) -> Unit) {
        onItemClickListener = listener
    }

    private var onItemClickListener: ((Note) -> Unit)? = null

}