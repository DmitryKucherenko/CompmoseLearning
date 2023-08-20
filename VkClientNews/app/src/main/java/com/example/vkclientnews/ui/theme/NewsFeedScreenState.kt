package com.example.vkclientnews.ui.theme

import com.example.vkclientnews.domain.FeedPost
import com.example.vkclientnews.domain.PostComment

sealed class NewsFeedScreenState {
    data class Posts(val posts: List<FeedPost>) : NewsFeedScreenState()
    object Initial : NewsFeedScreenState()
}
