package com.example.mycv.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Education")
data class Education
(
    @PrimaryKey(autoGenerate = true)
    var id: Int,

    var image: Int,
    var startDate: String,
    var finishDate: String,
    var town: String,
    var city: String
)