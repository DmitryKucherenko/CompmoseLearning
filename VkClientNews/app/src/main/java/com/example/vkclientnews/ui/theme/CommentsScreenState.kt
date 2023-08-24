package com.example.vkclientnews.ui.theme

import com.example.vkclientnews.domain.FeedPost
import com.example.vkclientnews.domain.PostComment

sealed class CommentsScreenState {

    object Initial : CommentsScreenState()

    data class Comments(
        val feedPost: FeedPost,
        val comments: List<PostComment>
    ) : CommentsScreenState()
}