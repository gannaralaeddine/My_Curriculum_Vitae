package com.example.mycv.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycv.Model.Experience
import com.example.mycv.R

class ExperienceAdapter(val listExperience: List<Experience>): RecyclerView.Adapter<ExperienceAdapter.ExperienceViewHolder>()
{
    class ExperienceViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val image =  itemView.findViewById<ImageView>(R.id.img_experience)
        val companyName =  itemView.findViewById<TextView>(R.id.txt_companyName)
        val companyAddress = itemView.findViewById<TextView>(R.id.txt_companyAddress)
        val startDate = itemView.findViewById<TextView>(R.id.txt_startDate)
        val endDate = itemView.findViewById<TextView>(R.id.txt_endDate)
        val desc = itemView.findViewById<TextView>(R.id.txt_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperienceViewHolder
    {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_experience, parent, false)
        return ExperienceViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExperienceViewHolder, position: Int)
    {
        holder.image.setImageResource(listExperience.get(position).image)
        holder.companyName.setText(listExperience.get(position).companyName)
        holder.companyAddress.setText(listExperience.get(position).companyAddress)
        holder.startDate.setText(listExperience.get(position).startDate)
        holder.endDate.setText(listExperience.get(position).endDate)
        holder.desc.setText(listExperience.get(position).desc)
    }

    override fun getItemCount(): Int = listExperience.size
}