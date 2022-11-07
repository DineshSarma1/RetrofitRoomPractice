package com.example.retrofitroompractice4.data.province

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.retrofitroompractice4.util.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ProvinceRepository {

    fun getProvinces(): Flow<Resource<List<Province>>>

}