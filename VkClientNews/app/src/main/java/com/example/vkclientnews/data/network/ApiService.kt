package com.example.vkclientnews.data.network

import com.example.vkclientnews.data.model.LikesCountResponseDto
import com.example.vkclientnews.data.model.NewsFeedResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("newsfeed.getRecommended?v=5.131")
    suspend fun loadRecommendations(
        @Query("access_token") token: String
    ): NewsFeedResponseDto


    @GET("newsfeed.getRecommended?v=5.131")
    suspend fun loadRecommendations(
        @Query("access_token") token: String,
        @Query("start_from") startFrom: String
    ): NewsFeedResponseDto

    @GET("likes.add?v=5.131&type=post")
    suspend fun addLike(
        @Query("access token") token: String,
        @Query("owner_id") ownerId: Long,
        @Query("item_id") postId: Long
    ):LikesCountResponseDto

    @GET("likes.delete?v=5.131&type=post")
    suspend fun deleteLike(
        @Query("access token") token: String,
        @Query("owner_id") ownerId: Long,
        @Query("item_id") postId: Long
    ):LikesCountResponseDto




}