package com.example.retrofitroompractice4.view.provinces

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import com.example.retrofitroompractice4.R
import com.example.retrofitroompractice4.data.province.Province
import com.example.retrofitroompractice4.databinding.FragmentProvinceBinding
import com.example.retrofitroompractice4.handlers.ProvinceClickListener
import com.example.retrofitroompractice4.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProvinceFragment : Fragment(R.layout.fragment_province), ProvinceClickListener {

    private lateinit var binding: FragmentProvinceBinding
    private lateinit var viewModel: ProvinceViewModel
    private lateinit var adapter: ProvinceAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentProvinceBinding.bind(view)

        setUpUI()
        setUpObserver()

    }

    private fun setUpUI() {
        adapter = ProvinceAdapter(listener = this)
        binding.provinceRecyclerView.adapter = adapter
    }

    private fun setUpObserver() {
        viewModel = ViewModelProvider(requireActivity())[ProvinceViewModel::class.java]

        binding.viewModel = viewModel
        viewModel.data.observe(viewLifecycleOwner) { result ->
            result.data?.let {
                adapter.updateList(result.data)

                binding.loadingProgressBar.isVisible = result is Resource.Loading && result.data.isEmpty()
                binding.loadingProgressBar.isVisible = result is Resource.Error && result.data.isEmpty()
                binding.errorTV.text = result.error?.localizedMessage
            }
        }
        /*viewModel.getProvinceObserver().observe(viewLifecycleOwner) { provinceList ->
            provinceList?.let {
                adapter.updateList(it)
            }
        }*/
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProvinceFragment()
    }

    override fun onProvinceClicked(province: Province) {
        val bundle = Bundle()//passing province to next fragment
        bundle.putString("name", province.name)
        bundle.putString("imageUrl", province.imageUrl)
        bundle.putString("description", province.description)
        bundle.putInt("id", 1)

        findNavController().navigate(R.id.action_provinceFragment_to_feedbackFragment, bundle)
    }
}
/* to navigate to another fragment put this line inside clickListener method
findNavController().navigate(R.id.action_provinceFragment_to_feedbackFragment)
*/
