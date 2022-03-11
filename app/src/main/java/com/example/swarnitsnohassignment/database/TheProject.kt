package com.example.swarnitsnohassignment.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "project_table")
data class TheProject(
    // Id which will be used to access the data
    @ColumnInfo(name = "logic")
    val anything: String //You can use anything here whether it be a string, boolean, etc.
    ){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var code: Long = 0
}
