package com.example.myapplication

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.databinding.FragmentNewTaskSheetBinding

class TaskViewModel : ViewModel() {

    var name = MutableLiveData<String>()
    var description = MutableLiveData<String>()
}