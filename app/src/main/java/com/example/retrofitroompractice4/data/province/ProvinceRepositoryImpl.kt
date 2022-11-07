package com.example.retrofitroompractice4.data.province

import androidx.room.withTransaction
import com.example.retrofitroompractice4.database.MyDatabase
import com.example.retrofitroompractice4.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class ProvinceRepositoryImpl @Inject constructor(
    private val db: MyDatabase,
    private val apiService: ApiService
) : ProvinceRepository {

    private val dao = db.provinceDao

    override fun getProvinces() = networkBoundResource(
        query = {
            dao.getProvinces()
        },
        fetch = {
            apiService.getProvinces()
        },
        saveFetchResult = { provinces ->
            db.withTransaction {
                dao.deleteAllProvinces()
                dao.insertAllProvince(provinces)
            }
        }
    )

}