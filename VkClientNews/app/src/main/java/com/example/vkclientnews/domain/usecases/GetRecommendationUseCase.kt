package com.example.vkclientnews.domain.usecases

import com.example.vkclientnews.data.repository.NewsFeedRepository
import com.example.vkclientnews.domain.entity.FeedPost
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class GetRecommendationUseCase @Inject constructor(
    private val repository: NewsFeedRepository
) {
    operator fun invoke(): StateFlow<List<FeedPost>> {
        return repository.getRecommendations()
    }
}