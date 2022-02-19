package com.lyvetech.bee.feature.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import com.lyvetech.bee.feature.data.local.entity.WordInfoDatabase
import com.lyvetech.bee.feature.data.remote.DictionaryApi
import com.lyvetech.bee.feature.data.remote.DictionaryApi.Companion.BASE_URL
import com.lyvetech.bee.feature.data.repository.WordInfoRepositoryImpl
import com.lyvetech.bee.feature.data.util.GsonParser
import com.lyvetech.bee.feature.domain.repository.WordInfoRepository
import com.lyvetech.bee.feature.domain.usecases.GetWordInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WordInfoModule {

    @Provides
    @Singleton
    fun providesGetWordInfoUseCase(repository: WordInfoRepository): GetWordInfo {
        return GetWordInfo(repository)
    }

    @Provides
    @Singleton
    fun providesWordInfoRepository(
        db: WordInfoDatabase,
        api: DictionaryApi
    ): WordInfoRepository {
        return WordInfoRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun providesWordInfoDatabase(app: Application): WordInfoDatabase {
        return Room.databaseBuilder(
            app, WordInfoDatabase::class.java, "word_db"
        ).addTypeConverter(GsonParser(Gson()))
            .build()
    }

    @Provides
    @Singleton
    fun providesDictionaryApi(): DictionaryApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DictionaryApi::class.java)
    }

}