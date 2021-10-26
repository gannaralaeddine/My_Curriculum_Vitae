package com.example.mycv.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycv.Adapters.EducationAdapter
import com.example.mycv.Model.Education
import com.example.mycv.R
import com.example.mycv.Utils.Education.EducationViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import java.util.ArrayList

class FragmentEducation : Fragment()
{
    var educationList: ArrayList<Education> = ArrayList()

    @InternalCoroutinesApi
    private lateinit var mEducationViewModel: EducationViewModel


    @InternalCoroutinesApi
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {

        val view = inflater.inflate(R.layout.fragment_education, container, false)

//        educationList.add(Education(0, R.drawable.ic_logo_massachusetts, "12/25/2021", "12/25/2022", "Massachusetts", "United States"))
//        educationList.add(Education(0, R.drawable.ic_logo_oxford, "12/25/2021", "12/25/2022", "oxford", "United Kingdom"))
//        educationList.add(Education(0, R.drawable.ic_logo_stanford, "12/25/2021", "12/25/2022", "stanford", "United States"))
//        educationList.add(Education(0, R.drawable.ic_logo_cambridge, "12/25/2021", "12/25/2022", "cambridge", "United Kingdom"))
//        educationList.add(Education(0, R.drawable.ic_logo_harvard, "12/25/2021", "12/25/2022", "harvard", "United States"))
//        educationList.add(Education(0, R.drawable.ic_logo_massachusetts, "12/25/2021", "12/25/2022", "Massachusetts", "United States"))
//        educationList.add(Education(0, R.drawable.ic_logo_oxford, "12/25/2021", "12/25/2022", "oxford", "United Kingdom"))
//        educationList.add(Education(0, R.drawable.ic_logo_stanford, "12/25/2021", "12/25/2022", "stanford", "United States"))


        val recycler: RecyclerView = view.findViewById(R.id.recyclerview_education)

        mEducationViewModel = ViewModelProvider(this).get(EducationViewModel::class.java)



        val adapter = EducationAdapter(educationList)

        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.setHasFixedSize(true)


        mEducationViewModel = ViewModelProvider(this).get(EducationViewModel::class.java)
        mEducationViewModel.readAll.observe(viewLifecycleOwner, Observer { educations ->
            adapter.setData(educations)
        })
        // Inflate the layout for this fragment
        return view
    }
}