package com.example.swarnitsnohassignment.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TheProject::class], version = 1, exportSchema = false)
abstract class ProjectDB : RoomDatabase(){

    abstract fun getDao() : TheProjectDAO

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: ProjectDB? = null

        //IMPORTANT
        //what are we passing here
        //context argument ???
        fun getDatabase(context: Context): ProjectDB {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database

//            ?: this is an Elvis operator below
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProjectDB::class.java,
                    "project_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}