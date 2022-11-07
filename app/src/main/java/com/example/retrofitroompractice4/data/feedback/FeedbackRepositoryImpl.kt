package com.example.retrofitroompractice4.data.feedback

import javax.inject.Inject

class FeedbackRepositoryImpl(
    private val dao: FeedbackDao
) : FeedbackRepository {
    override suspend fun insertFeedBack(feedback: Feedback) {
        dao.insertFeedBack(feedback)
    }

    override suspend fun deleteFeedBack(feedback: Feedback) {
        dao.deleteFeedBack(feedback)
    }

    override fun getFeedbacks(): MutableList<Feedback> {
        return dao.getFeedbacks()
    }

}