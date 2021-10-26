package com.example.mycv.Utils.Experience

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mycv.Model.Education
import com.example.mycv.Model.Experience

@Database(entities = [Experience::class, Education::class], version = 1, exportSchema = false)
abstract class ExperienceDatabase: RoomDatabase()
{
    abstract fun experienceDao(): DAOExperience

    companion object
    {
        @Volatile
        private var INSTANCE: ExperienceDatabase? = null

        fun getDatabase(context: Context): ExperienceDatabase
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
                    ExperienceDatabase::class.java,
                    "room_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}