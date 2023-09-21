package com.example.vkclientnews.data.repository

import android.app.Application
import com.example.vkclientnews.data.mapper.NewsFeedMapper
import com.example.vkclientnews.data.network.ApiFactory
import com.example.vkclientnews.domain.FeedPost
import com.vk.api.sdk.VKPreferencesKeyValueStorage
import com.vk.api.sdk.auth.VKAccessToken

class NewsFeedRepository(application: Application) {
    private val storage = VKPreferencesKeyValueStorage(application)
    private val token = VKAccessToken.restore(storage)

    private val apiService = ApiFactory.apiService
    private val mapper = NewsFeedMapper()

    suspend fun loadRecommendations(): List<FeedPost> {
        val response = apiService.loadRecommendations(getAccessToken())
        return mapper.mapResponseToPosts(response)
    }

    private fun getAccessToken(): String {
        return token?.accessToken ?: throw java.lang.IllegalStateException("Token is null")
    }

    suspend fun addLike(feedPost: FeedPost) {
        apiService.addLike(
            token = getAccessToken(),
            ownerId = feedPost.communityId,
            postId = feedPost.id
        )
    }
}