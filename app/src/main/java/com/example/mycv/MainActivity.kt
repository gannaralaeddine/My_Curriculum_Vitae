package com.example.mycv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.setTitle("Create your resume")
        setSupportActionBar(toolbar)

        findViewById<Button>(R.id.btn_main_next).setOnClickListener {

            //val intent: Intent = Intent(this, CreateResume::class.java)
            startActivity(Intent(this, YourResume::class.java))
        }


    }
}