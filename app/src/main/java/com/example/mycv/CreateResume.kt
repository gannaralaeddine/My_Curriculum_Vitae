package com.example.mycv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.Toolbar

class CreateResume : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_resume)


        val toolbar : Toolbar = findViewById(R.id.toolbar)
        toolbar.setTitle("Create your resume")
        setSupportActionBar(toolbar)

        findViewById<Button>(R.id.btn_createResume_submit).setOnClickListener {
             //val intent: Intent = Intent(this, YourResume::class.java)

            startActivity(Intent(this, YourResume::class.java))
        }

    }
}