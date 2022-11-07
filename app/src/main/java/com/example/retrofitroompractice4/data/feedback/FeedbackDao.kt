package com.example.retrofitroompractice4.data.feedback

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FeedbackDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFeedBack(feedback: Feedback)

    @Delete
    suspend fun deleteFeedBack(feedback: Feedback)

    @Query("SELECT * FROM feedback")
    fun getFeedbacks() : MutableList<Feedback>

}