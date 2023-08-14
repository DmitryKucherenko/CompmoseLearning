package com.example.vkclientnews.ui.theme

import com.example.vkclientnews.domain.FeedPost
import com.example.vkclientnews.domain.PostComment

sealed class HomeScreenState {
    data class Posts(val posts: List<FeedPost>) : HomeScreenState()
    data class Comments(val feedPost: FeedPost, val comments: List<PostComment>) : HomeScreenState()
    object Initial : HomeScreenState()

}
