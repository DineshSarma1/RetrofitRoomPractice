package com.example.retrofitroompractice4.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.retrofitroompractice4.data.feedback.Feedback
import com.example.retrofitroompractice4.data.feedback.FeedbackDao
import com.example.retrofitroompractice4.data.province.Province
import com.example.retrofitroompractice4.data.province.ProvinceDao

@Database(
    entities = [Province::class, Feedback::class],
    version = 1,
    exportSchema = false
)
abstract class MyDatabase : RoomDatabase() {

    //dao object
    abstract val provinceDao: ProvinceDao
    abstract val feedbackDao: FeedbackDao

}