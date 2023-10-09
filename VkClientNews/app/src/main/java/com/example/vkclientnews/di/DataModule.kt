package com.example.vkclientnews.di

import android.content.Context
import com.example.vkclientnews.data.network.ApiFactory
import com.example.vkclientnews.data.network.ApiService
import com.example.vkclientnews.data.repository.NewsFeedRepository
import com.example.vkclientnews.data.repository.NewsFeedRepositoryImpl
import com.vk.api.sdk.VKPreferencesKeyValueStorage
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindRepository(impl: NewsFeedRepositoryImpl):NewsFeedRepository

    companion object{
        @ApplicationScope
        @Provides
        fun provideApiService():ApiService{
            return ApiFactory.apiService
        }

        @ApplicationScope
        @Provides
        fun provideVkStorage(
            context: Context
        ):VKPreferencesKeyValueStorage{
          return VKPreferencesKeyValueStorage(context)
        }
    }


}