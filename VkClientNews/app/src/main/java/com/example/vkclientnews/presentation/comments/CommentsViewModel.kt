package com.example.vkclientnews.presentation.comments

import android.app.Application
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.*

import com.example.vkclientnews.data.repository.NewsFeedRepository
import com.example.vkclientnews.domain.FeedPost
import com.example.vkclientnews.domain.PostComment
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class CommentsViewModel(
    feedPost: FeedPost,
    application: Application
) : AndroidViewModel(application) {

    private val repository = NewsFeedRepository(application)

    val screenState = repository.loadComments(feedPost)
        .map{
            CommentsScreenState.Comments(feedPost,it) as CommentsScreenState
        }


}
