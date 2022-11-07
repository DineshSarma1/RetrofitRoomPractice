package com.example.retrofitroompractice4.data.province

import com.example.retrofitroompractice4.data.province.Province
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("api/Province/GetProvinces")
    suspend fun getProvinces(): List<Province>

}