package com.example.swarnitsnohassignment.ui.home

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.example.swarnitsnohassignment.database.ProjectDB
import com.example.swarnitsnohassignment.database.TheProject
import com.example.swarnitsnohassignment.repository.HomeRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    //repo needs dao that's why giving error
    private val repository : HomeRepo
    val allProjects: LiveData<List<TheProject>>

    init {
        val dao = ProjectDB.getDatabase(application).getDao()
        repository = HomeRepo(dao)
        allProjects = repository.getAll()
    }

    fun insert(project : TheProject) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(project)
    }

    fun delete() = viewModelScope.launch(Dispatchers.IO){
        repository.deleteAll()

    }

}