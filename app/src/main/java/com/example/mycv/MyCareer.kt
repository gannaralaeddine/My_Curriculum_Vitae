package com.example.mycv

import android.content.Intent
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycv.Fragments.FragmentEducation
import com.example.mycv.Fragments.FragmentExperience
import com.example.mycv.Model.Education
import java.util.ArrayList

class MyCareer : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_career)

        val toolbar1 = findViewById<Toolbar>(R.id.toolbar1)
        toolbar1.setTitle("Your Career")
        setSupportActionBar(toolbar1)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        openFragment(FragmentExperience())

        findViewById<Button>(R.id.btn_experience).setOnClickListener {
            openFragment(FragmentExperience())
        }

        findViewById<Button>(R.id.btn_education).setOnClickListener {
            openFragment(FragmentEducation())
        }

    }

    private fun openFragment(fragment: Fragment)
    {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_my_career, fragment).addToBackStack("").commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.menu1, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when (item.itemId)
        {
            R.id.menu1_addEducation -> startActivity(Intent(this, AddEducation::class.java))
            R.id.menu1_addExperience -> startActivity(Intent(this, AddExperience::class.java))
        }
        return super.onOptionsItemSelected(item)
    }


}