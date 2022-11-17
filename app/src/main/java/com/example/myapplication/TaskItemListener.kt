package com.example.myapplication

interface TaskItemListener {

    fun editTaskItem(taskItem: ClassItem)
    fun completeTaskItem(taskItem: ClassItem)
}