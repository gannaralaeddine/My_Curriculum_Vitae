package com.example.mycv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.mycv.Fragments.FragmentHobbies
import com.example.mycv.Fragments.FragmentLanguage
import com.example.mycv.Fragments.FragmentSkills

class YourResume : AppCompatActivity()
{



    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_your_resume)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.setTitle("Your Resume")
        setSupportActionBar(toolbar)

        openFragment(FragmentSkills())

        findViewById<Button>(R.id.btn_yourResume_skills).setOnClickListener {
            openFragment(FragmentSkills())
        }

        findViewById<Button>(R.id.btn_yourResume_hobbies).setOnClickListener {
            openFragment(FragmentHobbies())
        }

        findViewById<Button>(R.id.btn_yourResume_language).setOnClickListener {
            openFragment(FragmentLanguage())
        }

        findViewById<Button>(R.id.btn_yourResume_myCareer).setOnClickListener {
            startActivity(Intent(this, MyCareer::class.java))
        }

        val alert = AlertDialog.Builder(this)
        alert.setTitle("Logout")
        alert.setPositiveButton(android.R.string.yes) { dialog, which ->
            Toast.makeText(applicationContext,
                android.R.string.yes, Toast.LENGTH_SHORT).show()
        }
        alert.setNeutralButton("NO") { dialog, which ->
            Toast.makeText(applicationContext,
                "Maybe", Toast.LENGTH_SHORT).show()
        }
    }

    private fun openFragment(fragment: Fragment)
    {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer_yourResume, fragment).addToBackStack("").commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when (item.itemId)
        {
            R.id.menu_logout -> {
                val alert = AlertDialog.Builder(this)
                alert.setTitle("Logout")
                alert.setMessage("Are you sure you want to logout ?")
                alert.setPositiveButton("Yes") { dialog, which ->
                    android.widget.Toast.makeText(
                        applicationContext,
                        android.R.string.yes, android.widget.Toast.LENGTH_SHORT
                    ).show()
                }
                alert.setNegativeButton("No") { dialog, which ->
                    android.widget.Toast.makeText(
                        applicationContext,
                        "Maybe", android.widget.Toast.LENGTH_SHORT
                    ).show()
                }
                alert.show()
            }
            R.id.menu_info -> Log.e("menu", "click info")
        }

        return super.onOptionsItemSelected(item)
    }


}