package com.example.retrofitroompractice4.view.feedback

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitroompractice4.data.feedback.Feedback
import com.example.retrofitroompractice4.data.feedback.FeedbackRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedbackViewModel @Inject constructor(
    private val repository: FeedbackRepository
) : ViewModel() {

    private val _data: MutableLiveData<List<Feedback>> = MutableLiveData()
    val data: LiveData<List<Feedback>> = _data

    val message = MutableLiveData<String>()
    val rating = MutableLiveData<String>()

    init {
        loadData()
    }

    fun onSaveClicked() {
        val feedback = Feedback(message.value.toString(), rating.value!!.toFloat(), 0)
        insertFeedback(feedback)
    }

    fun getFeedbackObserver() : LiveData<List<Feedback>> {
        return data
    }

    private fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            _data.postValue(repository.getFeedbacks())
        }

    }

    private fun insertFeedback(feedback: Feedback) {
        viewModelScope.launch {
            repository.insertFeedBack(feedback)
            loadData()
        }
    }

    fun deleteFeedback(feedback: Feedback) {
        viewModelScope.launch {
            repository.deleteFeedBack(feedback)
            loadData()
        }
    }


}