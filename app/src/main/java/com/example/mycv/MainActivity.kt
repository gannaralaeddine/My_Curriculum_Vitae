package com.example.mycv

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity()
{

// SharedPreferences declaration
    private lateinit var mPreferences: SharedPreferences
    private lateinit var mEditor: SharedPreferences.Editor

    private lateinit var txtInputFullname: TextInputLayout
    private lateinit var txtInputEmail: TextInputLayout
    private lateinit var txtInputAge: TextInputLayout
    private lateinit var editFullname: EditText
    private lateinit var editEmail: EditText
    private lateinit var editAge: EditText
    private lateinit var checkRememberMe: CheckBox

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// Init
        mPreferences = getSharedPreferences("prefs", MODE_PRIVATE)

// Toolbar Configuration
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.setTitle("Create your resume")
        setSupportActionBar(toolbar)

// Directly connect if Remember Me is Checked
        if (mPreferences.getBoolean("isConnected", false))
        {
            startActivity(Intent(this, CreateResume::class.java))
        }

// Finding Views
        txtInputFullname = findViewById(R.id.main_txtinput_fullname)
        txtInputEmail = findViewById(R.id.main_txtinput_email)
        txtInputAge = findViewById(R.id.main_txtinput_age)
        editFullname = findViewById(R.id.main_fullname)
        editEmail = findViewById(R.id.main_email)
        editAge = findViewById(R.id.main_age)
        checkRememberMe = findViewById(R.id.main_rememberMe)


// Get data from SharedPreferences
        val fullname = mPreferences.getString("fullname", "")
        val email = mPreferences.getString("email", "")
        if (!fullname.equals(""))
        {
            editFullname.setText(fullname)
            editEmail.setText(email)
        }

// Save data to SharedPreferences
        findViewById<Button>(R.id.btn_main_next).setOnClickListener {
            if (checkFields())
            {
                mEditor = mPreferences.edit()
                mEditor.putString("fullname", editFullname.text.toString())
                mEditor.putString("email", editEmail.text.toString())
                if (checkRememberMe.isChecked) {
                    mEditor.putBoolean("isConnected", true)
                }
                mEditor.apply()
                startActivity(Intent(this, CreateResume::class.java))
                finish()
            }
        }
// Check text input
        editFullname.doOnTextChanged { text, start, before, count ->
            if (text!!.length > 20)
            {
                txtInputFullname.error = "No More Remove one character please!"
            }
            else
            {
                txtInputFullname.error = null
            }
        }

        editEmail.doOnTextChanged { text, start, before, count ->
            if (text!!.length > 30)
            {
                txtInputEmail.error = "No More Remove one character please!"
            }
            else
            {
                txtInputEmail.error = null
            }
        }

        editAge.doOnTextChanged { text, start, before, count ->
            if (text!!.length > 2)
            {
                txtInputAge.error = "No More Remove one character please!"
            }
            else
            {
                txtInputAge.error = null
            }
        }
    }

    private fun checkFields(): Boolean
    {
        txtInputFullname.error = null
        txtInputEmail.error = null
        txtInputAge.error = null

        if (editFullname.text.isEmpty())
        {
            txtInputFullname.error = getString(R.string.must_not_be_empty)
            return false
        }
        if (editFullname.text.length > 20)
        {
            txtInputFullname.error = "No More Remove one character please!"
            return false
        }

        if (editEmail.text.isEmpty())
        {
            txtInputEmail.error = getString(R.string.must_not_be_empty)
            return false
        }
        if (editEmail.text.length > 30)
        {
            txtInputEmail.error = "No More Remove one character please!"
            return false
        }

        if (editAge.text.isEmpty())
        {
            txtInputAge.error = getString(R.string.must_not_be_empty)
            return false
        }
        if (editAge.text.length > 2)
        {
            txtInputAge.error = "No More Remove one character please!"
            return false
        }

        return true
    }
}