package com.example.mycv.Utils.Education

import androidx.lifecycle.LiveData
import com.example.mycv.Model.Education


class EducationRepository(private val educationDao: DAOEducation)
{
    suspend fun addEducation(education: Education) = educationDao.addEducation(education)

    suspend fun updateEducation(education: Education) = educationDao.updateEducation(education)

    suspend fun deleteEducation(education: Education) = educationDao.deleteEducation(education)

    fun getAllEducations(): LiveData<List<Education>> = educationDao.getAllEducations()
}