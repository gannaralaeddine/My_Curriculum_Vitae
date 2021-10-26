package com.example.mycv.Model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Experience")
data class Experience (

    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var image: Int,
    var companyName: String,
    var companyAddress: String,
    var startDate: String,
    var endDate: String,
    var desc: String
        )