package com.example.retrofitroompractice4.data.province

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ProvinceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllProvince(provinces: List<Province>)

    @Query("SELECT * FROM province")
    fun getProvinces() : Flow<List<Province>>

    @Query("DELETE FROM province")
    suspend fun deleteAllProvinces()

}