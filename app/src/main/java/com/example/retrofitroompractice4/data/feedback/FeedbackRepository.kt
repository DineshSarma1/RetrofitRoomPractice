package com.example.retrofitroompractice4.data.feedback

interface FeedbackRepository {

    suspend fun insertFeedBack(feedback: Feedback)
    suspend fun deleteFeedBack(feedback: Feedback)
    fun getFeedbacks() : MutableList<Feedback>

}