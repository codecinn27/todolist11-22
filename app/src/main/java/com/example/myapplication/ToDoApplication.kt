package com.example.myapplication

import android.app.Application

class ToDoApplication : Application()
{

    private val database by lazy{ TaskItemDatabase.getDataBase(this)}
    val repository by lazy { TaskItemRepository(database.taskItemDao()) }
}