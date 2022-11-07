package com.example.retrofitroompractice4.handlers

import com.example.retrofitroompractice4.data.feedback.Feedback

interface FeedbackClickListener {
    fun onDeleteClicked(feedback: Feedback)
}