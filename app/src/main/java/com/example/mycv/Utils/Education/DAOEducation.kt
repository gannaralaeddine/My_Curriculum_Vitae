package com.example.mycv.Utils.Education

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mycv.Model.Education

@Dao
interface DAOEducation
{
    @Insert
    suspend fun addEducation(education: Education)

    @Update
    suspend fun updateEducation(education: Education)

    @Query("SELECT * FROM Education")
    fun getAllEducations(): LiveData<List<Education>>

    @Delete
    suspend fun deleteEducation(education: Education)
}