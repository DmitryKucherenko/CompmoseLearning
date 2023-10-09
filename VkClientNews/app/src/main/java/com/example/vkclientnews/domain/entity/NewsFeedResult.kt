package com.example.vkclientnews.domain.entity

sealed class NewsFeedResult {
    object Error: NewsFeedResult()
    data class Success(val post:List<FeedPost>): NewsFeedResult()
}