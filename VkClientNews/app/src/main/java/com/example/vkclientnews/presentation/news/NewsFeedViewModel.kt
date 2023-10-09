package com.example.vkclientnews.presentation.news

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkclientnews.data.repository.NewsFeedRepositoryImpl
import com.example.vkclientnews.domain.entity.FeedPost
import com.example.vkclientnews.domain.usecases.ChangeLikeStatusUseCase
import com.example.vkclientnews.domain.usecases.DeletePostUseCase
import com.example.vkclientnews.domain.usecases.GetRecommendationUseCase
import com.example.vkclientnews.domain.usecases.LoadNextDataUseCase
import com.example.vkclientnews.extensions.mergeWith
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsFeedViewModel @Inject constructor(
    private val getRecommendationUseCase:GetRecommendationUseCase,
            private val loadNextDataUseCase : LoadNextDataUseCase,
            private val changeLikeStatusUseCase:ChangeLikeStatusUseCase,
            private val deletePostUseCase : DeletePostUseCase

) : ViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler{_,_ ->
        Log.d("NewsFeedViewModel","Exception caught by exception handler")
    }



    private val recommendationsFlow = getRecommendationUseCase()


    private val loadNextDataEvents = MutableSharedFlow<Unit>()

    private val loadNextDataFlow = flow{
      loadNextDataEvents.collect{
          emit(NewsFeedScreenState.Posts(
              posts = recommendationsFlow.value,
              nextDataIsLoading = true
          ))
      }
    }

    val screenState = recommendationsFlow
        .filter { it.isNotEmpty() }
        .map{NewsFeedScreenState.Posts(posts = it) as NewsFeedScreenState}
        .onStart { emit(NewsFeedScreenState.Loading) }
        .mergeWith(loadNextDataFlow)




     fun loadNextRecommendation() {
        viewModelScope.launch {
            loadNextDataEvents.emit(Unit)
            loadNextDataUseCase()
        }
    }



    fun changeLikeStatus(feedPost: FeedPost) {
        viewModelScope.launch(exceptionHandler) {
             changeLikeStatusUseCase(feedPost)
        }
    }


    fun remove(feedPost: FeedPost) {
        viewModelScope.launch(exceptionHandler) {
            deletePostUseCase(feedPost)
        }
    }

}