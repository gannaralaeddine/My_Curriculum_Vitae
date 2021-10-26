package com.example.mycv.Utils.Experience

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mycv.Model.Education
import com.example.mycv.Model.Experience

@Dao
interface DAOExperience
{
    @Insert
    suspend fun addExperience(experience: Experience)

    @Update
    suspend fun updateExperience(experience: Experience)

    @Query("SELECT * FROM Experience")
    fun getAllExperiences(): LiveData<List<Experience>>

    @Delete
    suspend fun deleteExperience(experience: Experience)
}