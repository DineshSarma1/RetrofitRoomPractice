package com.example.retrofitroompractice4.view.feedback

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitroompractice4.R
import com.example.retrofitroompractice4.data.feedback.Feedback
import com.example.retrofitroompractice4.data.province.Province
import com.example.retrofitroompractice4.databinding.FragmentFeedbackBinding
import com.example.retrofitroompractice4.handlers.FeedbackClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedbackFragment : Fragment(R.layout.fragment_feedback), FeedbackClickListener {

    private lateinit var binding: FragmentFeedbackBinding
    private lateinit var viewModel: FeedbackViewModel
    private lateinit var adapter: FeedbackAdapter
    private lateinit var province: Province

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //receiving data from previous fragment
        getArgumentsData()

        //initializing view binding
        binding = FragmentFeedbackBinding.bind(view)

        setUpUI()

        initViewModel()

        setUpObserver()
    }

    private fun getArgumentsData() {
        val name = arguments?.getString("name")
        val imageUrl = arguments?.getString("imageUrl")
        val description = arguments?.getString("description")
        val id = arguments?.getInt("id")
        province = Province(name!!, imageUrl!!, description!!, id)

    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(requireActivity())[FeedbackViewModel::class.java]
        binding.province = province
        binding.viewModel = viewModel
    }

    private fun setUpObserver() {
        viewModel.getFeedbackObserver().observe(viewLifecycleOwner) { feedbackList ->
            feedbackList?.let {
                adapter.updateList(it)
            }

        }
    }

    private fun setUpUI() {
        adapter = FeedbackAdapter(listener = this)
        binding.feedbackRecyclerView.adapter = adapter
    }

    companion object {
        @JvmStatic
        fun newInstance() = FeedbackFragment()
    }

    override fun onDeleteClicked(feedback: Feedback) {
        viewModel.deleteFeedback(feedback)
    }
}