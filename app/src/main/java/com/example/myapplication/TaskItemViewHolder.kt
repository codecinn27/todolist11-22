package com.example.myapplication

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentNewTaskSheetBinding
import com.example.myapplication.databinding.TaskItemCellBinding

class TaskItemViewHolder( private val context: Context, private val binding: TaskItemCellBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bindTaskItem(taskItem: ClassItem){
        binding.name.text = taskItem.name
    }
}