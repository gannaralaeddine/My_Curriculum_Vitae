package com.example.mycv.Utils.Education

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mycv.Model.Education
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

@InternalCoroutinesApi
class EducationViewModel(application: Application): AndroidViewModel(application)
{
    private val repo: EducationRepository
    var readAll: LiveData<List<Education>>

    init {
        val educationDB = EducationDatabase.getDatabase(application).educationDao()
        repo = EducationRepository(educationDB)
        readAll = repo.getAllEducations()
    }

    fun addEducation(education: Education)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repo.addEducation(education)
        }
    }
}