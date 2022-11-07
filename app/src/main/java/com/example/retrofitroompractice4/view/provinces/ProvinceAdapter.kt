package com.example.retrofitroompractice4.view.provinces

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitroompractice4.data.province.Province
import com.example.retrofitroompractice4.databinding.ItemProvinceBinding
import com.example.retrofitroompractice4.handlers.ProvinceClickListener

class ProvinceAdapter(
    private var provinceList: MutableList<Province> = mutableListOf(),
    private val listener: ProvinceClickListener
) : RecyclerView.Adapter<ProvinceAdapter.ProvinceViewHolder>(){

    inner class ProvinceViewHolder(private val binding: ItemProvinceBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(province: Province) {
            binding.province = province
            binding.clickListener = listener
        }
    }

    fun updateList(newList: List<Province>) {
        val result = DiffUtil.calculateDiff(DiffUtilCallbackImpl(provinceList, newList))
        provinceList.clear()
        provinceList.addAll(newList)
        result.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinceViewHolder {
        val binding = ItemProvinceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProvinceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProvinceViewHolder, position: Int) {
        holder.apply {
            bind(provinceList[position])
        }
    }

    override fun getItemCount(): Int = provinceList.size

    class DiffUtilCallbackImpl<Province> (private val oldList: List<Province>,private val newList: List<Province>): DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition] == newList[newItemPosition]

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition] == newList[newItemPosition]

    }
}