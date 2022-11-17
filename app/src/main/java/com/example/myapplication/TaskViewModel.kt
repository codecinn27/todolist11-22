package com.example.myapplication

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.databinding.FragmentNewTaskSheetBinding
import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID

class TaskViewModel : ViewModel() {

    var taskItem = MutableLiveData<MutableList<ClassItem>>()

    init{
        taskItem.value = mutableListOf()
    }

    fun addTaskItem(newTask: ClassItem){
        val list = taskItem.value
        list!!.add(newTask)
        taskItem.postValue(list)
    }

    fun updateTaskItem(id: UUID, name: String, desc:String, dueTime: LocalTime?){
        val list = taskItem.value
        val task = list!!.find{ it.id == id }!!
        task.name = name
        task.desc = desc
        task.dueTime =dueTime
        taskItem.postValue(list)
    }

    fun setCompleted(taskItems: ClassItem){
//        must be different name in the attribute dont overwrite it
        val list = taskItem.value
        val task = list!!.find{ it.id == taskItems.id}!!
        if(task.completeDate== null)
            task.completeDate = LocalDate.now()
        taskItem.postValue(list)
    }
}