package com.example.mycv

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.annotation.RequiresApi

class AddEducation : AppCompatActivity(), View.OnFocusChangeListener
{
    private var year = 0
    private var month = 0
    private var day = 0
    private lateinit var endDate: EditText
    private lateinit var datePick : DatePickerDialog

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_education)

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
    }


    override fun onFocusChange(p0: View?, p1: Boolean)
    {

    }
}