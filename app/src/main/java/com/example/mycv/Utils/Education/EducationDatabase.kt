package com.example.mycv.Utils.Education

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mycv.Model.Education
import com.example.mycv.Model.Experience

@Database(entities = [Education::class, Experience::class], version = 1, exportSchema = false)
abstract class EducationDatabase: RoomDatabase()
{
    abstract fun educationDao(): DAOEducation

    companion object
    {
        @Volatile
        private var INSTANCE: EducationDatabase? = null

        fun getDatabase(context: Context): EducationDatabase
        {
            val tempInstance = INSTANCE

            if (tempInstance != null)
            {
                return tempInstance
            }
            synchronized(this)
            {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EducationDatabase::class.java,
                    "room_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}