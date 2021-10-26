package com.example.mycv.Utils.Experience

import androidx.lifecycle.LiveData
import com.example.mycv.Model.Education
import com.example.mycv.Model.Experience


class ExperienceRepository(private val experienceDao: DAOExperience)
{
    suspend fun addExperience(experience: Experience) = experienceDao.addExperience(experience)

    suspend fun updateExperience(experience: Experience) = experienceDao.updateExperience(experience)

    suspend fun deleteExperience(experience: Experience) = experienceDao.deleteExperience(experience)

    fun getAllExperiences(): LiveData<List<Experience>> = experienceDao.getAllExperiences()
}