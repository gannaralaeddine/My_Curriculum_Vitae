package com.example.mycv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

class AddExperience : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_experience)

        val toolbar= findViewById<Toolbar>(R.id.toolbar)
        toolbar.setTitle(getString(R.string.add_experience))
        setSupportActionBar(toolbar)


    }
}