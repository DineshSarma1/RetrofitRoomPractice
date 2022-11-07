package com.example.retrofitroompractice4.view.feedback

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitroompractice4.data.feedback.Feedback
import com.example.retrofitroompractice4.databinding.ItemFeedbackBinding
import com.example.retrofitroompractice4.handlers.FeedbackClickListener

class FeedbackAdapter(
    private var feedbackList: MutableList<Feedback> = mutableListOf(),
    var listener: FeedbackClickListener
) : RecyclerView.Adapter<FeedbackAdapter.FeedbackViewHolder>(){

    //ViewHolder class
    inner class FeedbackViewHolder(val binding: ItemFeedbackBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(feedback: Feedback) {
            binding.feedback = feedback
            binding.clickListener = listener
        }
    }

    fun updateList(newFeedbacks: List<Feedback>) {
        val result = DiffUtil.calculateDiff(DiffUtilCallbackImpl<Feedback> (feedbackList, newFeedbacks))
        feedbackList.clear()
        feedbackList.addAll(newFeedbacks)
        result.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedbackViewHolder {
        return FeedbackViewHolder(ItemFeedbackBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: FeedbackViewHolder, position: Int) {
        holder.apply {
            bind(feedbackList[position])
        }
    }

    override fun getItemCount(): Int = feedbackList.size

    //to compare two list while calling the updateList method
    class DiffUtilCallbackImpl<Feedback>(val oldList: List<Feedback>, val newList: List<Feedback>): DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition] == newList[newItemPosition]

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition] == newList[newItemPosition]

    }

}