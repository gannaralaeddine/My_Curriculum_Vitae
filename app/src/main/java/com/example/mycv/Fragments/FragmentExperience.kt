package com.example.mycv.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycv.Adapters.ExperienceAdapter
import com.example.mycv.Model.Experience
import com.example.mycv.R
import java.util.ArrayList

class FragmentExperience : Fragment()
{

    var experienceList: ArrayList<Experience> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_experience, container, false)

//        experienceList.add(Experience(R.drawable.ic_logo_amazon, "AMAZON", "UNITED STATES", "01/09/2019", "TODAY", getString(R.string.description)))
//        experienceList.add(Experience(R.drawable.ic_logo_esprit, "ESPRIT", "TUNISIA", "01/09/2013", "31/08/2015", getString(R.string.description)))
//        experienceList.add(Experience(R.drawable.ic_logo_facebook, "FACEBOOK", "FRANCE", "01/09/2018", "31/08/2019", getString(R.string.description)))
//        experienceList.add(Experience(R.drawable.ic_logo_microsoft, "MICROSOFT", "UNITED KINGDOM", "01/09/2015", "31/08/2016", getString(R.string.description)))

        val recycler = root.findViewById<RecyclerView>(R.id.recyclerview_experience)

        recycler.adapter = ExperienceAdapter(experienceList)
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.setHasFixedSize(true)


        return root
    }


}