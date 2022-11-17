package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    must follow the name dont simply name
    private lateinit var taskViewModel: TaskViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        binding.newTaskButton.setOnClickListener {
            newTaskSheet().show(supportFragmentManager,"newTaskTag")
        }

        taskViewModel.name.observe(this){
            binding.taskName.text = String.format("Task Name: %s", it)
        }

        taskViewModel.description.observe(this){
            binding.taskDescription.text = String.format("Task Name: %s", it)
        }
    }
}