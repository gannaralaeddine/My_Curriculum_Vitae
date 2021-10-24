package com.example.mycv.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycv.Model.Education
import com.example.mycv.R

class EducationAdapter(val listEducations: List<Education>): RecyclerView.Adapter<EducationAdapter.EducationViewHolder>()
{

    class EducationViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val image =  itemView.findViewById<ImageView>(R.id.education_image)
        val startDate = itemView.findViewById<TextView>(R.id.education_start_date)
        val finishDate = itemView.findViewById<TextView>(R.id.education_finish_date)
        val town = itemView.findViewById<TextView>(R.id.education_town)
        val city = itemView.findViewById<TextView>(R.id.education_city)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducationViewHolder
    {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_education, parent, false)
        return EducationViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EducationViewHolder, position: Int)
    {
        holder.image.setImageResource(listEducations.get(position).image)
        holder.startDate.text = listEducations.get(position).startDate
        holder.finishDate.text = listEducations.get(position).finishDate
        holder.town.text = listEducations.get(position).town
        holder.city.text = listEducations.get(position).city
    }

    override fun getItemCount(): Int = listEducations.size
}