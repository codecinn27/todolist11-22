package com.example.myapplication

import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import com.example.myapplication.databinding.FragmentNewTaskSheetBinding
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID

class TaskViewModel(private val repository: TaskItemRepository) : ViewModel() {

    var taskItem: LiveData<List<ClassItem>> = repository.allTaskItem.asLiveData()


    fun addTaskItem(newTask: ClassItem) = viewModelScope.launch {
        repository.insertTaskItem(newTask)
    }

    fun updateTaskItem(taskItem: ClassItem) =viewModelScope.launch{
        repository.updateTaskItem(taskItem)
    }

    fun setCompleted(taskItem: ClassItem) =viewModelScope.launch{
        if(!taskItem.isCompleted())
            taskItem.completedDateString = ClassItem.dateFormmater.format(LocalDate.now())

        repository.updateTaskItem(taskItem)
    }

}

class TaskItemModelFactory(private val repository: TaskItemRepository): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java))
            return TaskViewModel(repository) as T

        throw IllegalAccessException("Unknown Class for View Model")

    }
}