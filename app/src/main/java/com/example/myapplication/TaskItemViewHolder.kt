package com.example.myapplication

import android.content.Context
import android.graphics.Paint
import android.widget.ExpandableListView.OnChildClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentNewTaskSheetBinding
import com.example.myapplication.databinding.TaskItemCellBinding
import java.time.format.DateTimeFormatter

class TaskItemViewHolder( private val context: Context, private val binding: TaskItemCellBinding, private val clickListener: TaskItemListener
): RecyclerView.ViewHolder(binding.root) {


    private val timeFormat = DateTimeFormatter.ofPattern("HH:mm")
    fun bindTaskItem(taskItem: ClassItem){
        binding.name.text = taskItem.name

        if(taskItem.isCompleted()){
            binding.name.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            binding.dueTime.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        }

        binding.completButton.setImageResource(taskItem.imageResource())
        binding.completButton.setColorFilter(taskItem.imageColor(context))

        binding.completButton.setOnClickListener{
            clickListener.completeTaskItem(taskItem)
        }
        binding.cardContainer.setOnClickListener{
            clickListener.editTaskItem(taskItem)
        }

        if(taskItem.dueTime() != null)
            binding.dueTime.text = timeFormat.format(taskItem.dueTime())
        else
            binding.dueTime.text = ""
    }
}