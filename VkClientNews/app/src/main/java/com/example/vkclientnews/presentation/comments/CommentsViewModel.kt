package com.example.vkclientnews.presentation.comments

import android.app.Application
import androidx.lifecycle.*

import com.example.vkclientnews.data.repository.NewsFeedRepository
import com.example.vkclientnews.domain.FeedPost
import com.example.vkclientnews.domain.PostComment
import kotlinx.coroutines.launch

class CommentsViewModel(
    feedPost: FeedPost,
    application: Application
) : AndroidViewModel(application) {

    private val _screenState = MutableLiveData<CommentsScreenState>(CommentsScreenState.Initial)
    val screenState: LiveData<CommentsScreenState> = _screenState
    private val repository = NewsFeedRepository(application)

    init {
        loadComments(feedPost)
    }

    private fun loadComments(feedPost: FeedPost) {
        viewModelScope.launch {
            val comments = repository.loadComments(feedPost)
            _screenState.value = CommentsScreenState.Comments(
                feedPost = feedPost,
                comments = comments
            )
        }
    }
}