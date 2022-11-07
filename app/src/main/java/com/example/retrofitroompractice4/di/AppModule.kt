package com.example.retrofitroompractice4.di

import android.app.Application
import androidx.room.Room
import com.example.retrofitroompractice4.data.province.ApiService
import com.example.retrofitroompractice4.constants.Constants
import com.example.retrofitroompractice4.constants.Constants.DB_NAME
import com.example.retrofitroompractice4.database.MyDatabase
import com.example.retrofitroompractice4.data.feedback.FeedbackRepository
import com.example.retrofitroompractice4.data.feedback.FeedbackRepositoryImpl
import com.example.retrofitroompractice4.data.province.ProvinceRepository
import com.example.retrofitroompractice4.data.province.ProvinceRepositoryImpl
import com.example.retrofitroompractice4.view.provinces.ProvinceViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Application): MyDatabase {
        return Room.databaseBuilder(
            context,
            MyDatabase::class.java,
            DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideFeedbackRepository(db: MyDatabase) : FeedbackRepository {
        return FeedbackRepositoryImpl(db.feedbackDao)
    }

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) : ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideProvinceRepository(db: MyDatabase, apiService: ApiService) : ProvinceRepository {
        return ProvinceRepositoryImpl(db, apiService)
    }

}