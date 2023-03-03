package com.example.moodtracker.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "diary_table")//name of table
class Note (
    @PrimaryKey(autoGenerate = true) val id : Int = 0,//building sqlLite database
    @ColumnInfo val title: String,//title of diary entry
    @ColumnInfo val info: String,//diary entry
    @ColumnInfo val date: String,//date of entry
    @ColumnInfo val time: String//time of entry

        ):Serializable
