package com.example.swarnitsnohassignment.repository

import androidx.lifecycle.LiveData
import com.example.swarnitsnohassignment.database.TheProject
import com.example.swarnitsnohassignment.database.TheProjectDAO

class HomeRepo(private val projectDao: TheProjectDAO) {


    suspend fun insert(projectModel : TheProject) = projectDao.insert(projectModel)

    fun deleteAll() = projectDao.deleteAll()

    fun getAll() :LiveData<List<TheProject>> = projectDao.getAll()

}