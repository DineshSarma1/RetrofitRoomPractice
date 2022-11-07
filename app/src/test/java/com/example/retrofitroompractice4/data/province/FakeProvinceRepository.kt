package com.example.retrofitroompractice4.data.province

import com.example.retrofitroompractice4.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeProvinceRepository : ProvinceRepository {

    lateinit var provinces: Resource<List<Province>>

    override fun getProvinces(): Flow<Resource<List<Province>>> {
        return flow { emit(provinces) }
    }

}