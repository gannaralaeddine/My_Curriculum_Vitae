package com.example.mycv.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycv.Adapters.EducationAdapter
import com.example.mycv.Model.Education
import com.example.mycv.R
import java.util.ArrayList

class FragmentEducation : Fragment()
{
    var educationList: ArrayList<Education> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {

        val root = inflater.inflate(R.layout.fragment_education, container, false)

        educationList.add(Education(R.drawable.ic_logo_massachusetts, "12/25/2021", "12/25/2022", "Massachusetts", "United States"))
        educationList.add(Education(R.drawable.ic_logo_oxford, "12/25/2021", "12/25/2022", "oxford", "United Kingdom"))
        educationList.add(Education(R.drawable.ic_logo_stanford, "12/25/2021", "12/25/2022", "stanford", "United States"))
        educationList.add(Education(R.drawable.ic_logo_cambridge, "12/25/2021", "12/25/2022", "cambridge", "United Kingdom"))
        educationList.add(Education(R.drawable.ic_logo_harvard, "12/25/2021", "12/25/2022", "harvard", "United States"))
        educationList.add(Education(R.drawable.ic_logo_massachusetts, "12/25/2021", "12/25/2022", "Massachusetts", "United States"))
        educationList.add(Education(R.drawable.ic_logo_oxford, "12/25/2021", "12/25/2022", "oxford", "United Kingdom"))
        educationList.add(Education(R.drawable.ic_logo_stanford, "12/25/2021", "12/25/2022", "stanford", "United States"))


        val recycler: RecyclerView = root.findViewById(R.id.recyclerview_education)

        recycler.adapter = EducationAdapter(educationList)
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.setHasFixedSize(true)

        // Inflate the layout for this fragment
        return root
    }
}