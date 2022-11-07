package com.example.retrofitroompractice4.data.feedback

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Feedback(
    var message: String,
    var rating: Float,
    var provinceId: Int,
    @PrimaryKey var id: Int? = null
)
