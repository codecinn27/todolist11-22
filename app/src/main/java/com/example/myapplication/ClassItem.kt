package com.example.myapplication

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.UUID

@Entity(tableName = "task_item_table")
class ClassItem(
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "desc") var desc: String,
    @ColumnInfo(name = "dueTimeString") var dueTimeString: String?,
    @ColumnInfo(name = "completedDataString") var completedDateString: String?,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
) {

    fun completedDate(): LocalDate? = if(completedDateString == null)null
        else LocalDate.parse(completedDateString)
    fun dueTime(): LocalTime? = if(completedDateString == null)null
        else LocalTime.parse(dueTimeString)

    fun isCompleted() = completedDate() != null
    fun imageResource(): Int = if (isCompleted()) R.drawable.ic_baseline_check_circle_outline_24 else R.drawable.ic_baseline_radio_button_unchecked_24
    fun imageColor(context: Context): Int = if(isCompleted()) purple(context) else black(context)

    private fun purple(context: Context) = ContextCompat.getColor(context, R.color.purple_500)
    private fun black(context: Context) = ContextCompat.getColor(context, R.color.black)


    companion object{
        val timeFormmater: DateTimeFormatter = DateTimeFormatter.ISO_TIME
        val dateFormmater: DateTimeFormatter = DateTimeFormatter.ISO_DATE
    }
}