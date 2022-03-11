package com.example.swarnitsnohassignment.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TheProjectDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(data: TheProject)


    @Query("Delete from project_table")
    fun deleteAll()

    @Query("Select * from project_table order by id ASC")
    fun getAll(): LiveData<List<TheProject>>

}