package com.example.retrofitroompractice4.view.provinces

import android.util.Log
import androidx.lifecycle.*
import com.example.retrofitroompractice4.data.feedback.FeedbackRepository
import com.example.retrofitroompractice4.data.province.Province
import com.example.retrofitroompractice4.data.province.ProvinceRepository
import com.example.retrofitroompractice4.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProvinceViewModel @Inject constructor(
    private val repository: ProvinceRepository
) : ViewModel() {

    val data = repository.getProvinces().asLiveData()


/*
    private val _data: MutableLiveData<List<Province>> = MutableLiveData()
    val data: LiveData<List<Province>> = _data

    init {
        loadData()
    }

    fun getProvinceObserver(): LiveData<List<Province>> {
        return data
    }

    fun gotoFeedbackPage() {

    }

    private fun loadData() {
        viewModelScope.launch {
            val provinces = repository.getProvinces()
            when(provinces.isSuccessful) {
                true -> {
                    with(provinces.body().orEmpty()) {
                        var provinceList = listOf<Province>()
                        forEach { ( name, imageUrl, description) ->
                            provinceList = provinceList + Province(name, imageUrl, description)
                        }
                        _data.postValue(provinceList)
                        insertAllProvince(provinceList)
                    }
                }

                false -> {
                    Log.e("ProvinceViewModel",provinces.message())
                }
            }
        }
    }

    private fun  insertAllProvince(provinces: List<Province>) {
        viewModelScope.launch {
            repository.insertAllProvinces(provinces)
        }
    }

    private fun insertProvince(province: Province) {
        viewModelScope.launch {
            repository.insertProvince(province)
        }
    }

    fun getProvinceById(id: Int) : Province? {
        return null
    }*/
}