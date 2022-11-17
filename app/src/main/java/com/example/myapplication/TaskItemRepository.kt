package com.example.myapplication

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow


class TaskItemRepository (private val taskItemDao:TaskItemDao)
{

    val allTaskItem: Flow<List<ClassItem>> = taskItemDao.allTaskItem()


    @WorkerThread
    suspend fun insertTaskItem(taskItem : ClassItem){

        taskItemDao.insertTaskItem(taskItem)
    }

    @WorkerThread
    suspend fun  updateTaskItem(taskItem: ClassItem){
        taskItemDao.updateTaskItem(taskItem)
    }
}