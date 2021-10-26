package com.example.mycv.Utils.Experience

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mycv.Model.Education
import com.example.mycv.Model.Experience
import com.example.mycv.Utils.Education.EducationDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class ExperienceViewModel(application: Application): AndroidViewModel(application)
{
    private val repo: ExperienceRepository
    private var readAll: LiveData<List<Experience>>

    init {
        val educationDB = ExperienceDatabase.getDatabase(application).experienceDao()
        repo = ExperienceRepository(educationDB)
        readAll = repo.getAllExperiences()
    }

    fun addExperience(experience: Experience)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repo.addExperience(experience)
        }
    }
}