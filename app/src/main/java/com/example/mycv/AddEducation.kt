package com.example.mycv

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.example.mycv.Model.Education
import com.example.mycv.Utils.Education.EducationViewModel
import kotlinx.coroutines.InternalCoroutinesApi

class AddEducation : AppCompatActivity(), View.OnFocusChangeListener
{
    private var year = 0
    private var month = 0
    private var day = 0
    private lateinit var endDate: EditText
    private lateinit var datePick : DatePickerDialog


    @InternalCoroutinesApi
    private lateinit var mEducationViewModel: EducationViewModel

    @InternalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_education)

        val toolbar= findViewById<Toolbar>(R.id.toolbar)
        toolbar.setTitle("Add Education")
        setSupportActionBar(toolbar)

        endDate = findViewById<EditText>(R.id.addEducation_endDate)

        endDate.setOnFocusChangeListener(this)

        //val datePicker = DatePickerDialog(this, date)

//        datePick = DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
//            this.year = year
//            this.month = month
//            this.day = day
//
//            endDate.setText(year + month + day)
//        }

        mEducationViewModel = ViewModelProvider(this).get(EducationViewModel::class.java)

        findViewById<Button>(R.id.btn_addEducation).setOnClickListener {
            insertData()
        }

    }

    @InternalCoroutinesApi
    fun insertData()
    {
        // Create user object
        val education = Education(0, R.drawable.ic_logo_massachusetts, "12/25/2021", "12/25/2022", "Massachusetts", "United States")

        // Add data to database
        mEducationViewModel.addEducation(education)

        Toast.makeText(applicationContext, "Add success", Toast.LENGTH_SHORT).show()
    }




    override fun onFocusChange(p0: View?, p1: Boolean)
    {

    }
}