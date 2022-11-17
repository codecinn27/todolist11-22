package com.example.myapplication

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentNewTaskSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class newTaskSheet(var taskItem: ClassItem?) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentNewTaskSheetBinding
    private lateinit var taskViewModel: TaskViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()

        if(taskItem != null){
            binding.titleText.text = "Edit Task"
            val editable = Editable.Factory.getInstance()
            binding.name.text = editable.newEditable(taskItem!!.name)
            binding.description.text = editable.newEditable((taskItem!!.desc))

        }else{
            binding.titleText.text = "New Task"
        }

        taskViewModel = ViewModelProvider(activity).get(TaskViewModel::class.java)
        binding.saveButton.setOnClickListener{
            saveAction()
        }
    }
    private fun saveAction() {
        val name = binding.name.text.toString()
        val desc = binding.description.text.toString()
        if(taskItem == null){
            val newTask = ClassItem(name, desc, null, null)
            taskViewModel.addTaskItem(newTask)
        }else{
            taskViewModel.updateTaskItem(taskItem!!.id  ,name,desc,null)
        }

        binding.name.setText("")
        binding.description.setText("")
        dismiss()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNewTaskSheetBinding.inflate(inflater,container,false  )
        return binding.root
    }

}