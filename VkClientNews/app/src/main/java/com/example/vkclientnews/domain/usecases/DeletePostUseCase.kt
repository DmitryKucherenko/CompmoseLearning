package com.example.vkclientnews.domain.usecases

import com.example.vkclientnews.data.repository.NewsFeedRepository
import com.example.vkclientnews.domain.entity.AuthState
import com.example.vkclientnews.domain.entity.FeedPost
import com.example.vkclientnews.domain.entity.PostComment
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class DeletePostUseCase @Inject constructor(
    private val repository: NewsFeedRepository
) {
    suspend operator fun invoke(feedPost: FeedPost) {
        return repository.deletePost(feedPost)
    }
}