package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), TaskItemListener {

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
            newTaskSheet(null).show(supportFragmentManager,"newTaskTag")
        }

        setRecyclerView()

    }

    private fun setRecyclerView() {
        val mainActivity = this
        taskViewModel.taskItem.observe(this){
            binding.todolistRecyclerView.apply {
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = TaskItemAdapter(it, mainActivity)
            }
        }
    }

    override fun editTaskItem(taskItem: ClassItem) {
        newTaskSheet(taskItem).show(supportFragmentManager,"newTaskTag")
    }

    override fun completeTaskItem(taskItem: ClassItem) {
        taskViewModel.setCompleted(taskItem)
    }
}