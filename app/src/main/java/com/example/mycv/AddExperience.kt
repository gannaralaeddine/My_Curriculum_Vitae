package com.example.mycv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.example.mycv.Model.Education
import com.example.mycv.Model.Experience
import com.example.mycv.Utils.Education.EducationViewModel
import com.example.mycv.Utils.Experience.ExperienceViewModel
import kotlinx.coroutines.InternalCoroutinesApi

class AddExperience : AppCompatActivity()
{
    @InternalCoroutinesApi
    private lateinit var mExperienceViewModel: ExperienceViewModel

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_experience)

        val toolbar= findViewById<Toolbar>(R.id.toolbar)
        toolbar.setTitle(getString(R.string.add_experience))
        setSupportActionBar(toolbar)


        mExperienceViewModel = ViewModelProvider(this).get(ExperienceViewModel::class.java)

        findViewById<Button>(R.id.btn_addExperience).setOnClickListener {
            // Create user object
            val experience = Experience(0, R.drawable.ic_logo_amazon, "AMAZON", "UNITED STATES", "01/09/2019", "TODAY", getString(R.string.description))

            // Add data to database
            mExperienceViewModel.addExperience(experience)

            Toast.makeText(applicationContext, "Add success", Toast.LENGTH_SHORT).show()
        }
    }
}