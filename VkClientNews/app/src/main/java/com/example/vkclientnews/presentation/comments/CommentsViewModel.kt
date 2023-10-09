package com.example.vkclientnews.presentation.comments

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.vkclientnews.data.repository.NewsFeedRepositoryImpl
import com.example.vkclientnews.domain.entity.FeedPost
import com.example.vkclientnews.domain.usecases.GetCommentsUseCase
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CommentsViewModel @Inject constructor(
    feedPost: FeedPost,
    private val getCommentsUseCase:GetCommentsUseCase
) :ViewModel(){
   val screenState = getCommentsUseCase(feedPost)
        .map {
            CommentsScreenState.Comments(
                feedPost, it
            )
        }
}
