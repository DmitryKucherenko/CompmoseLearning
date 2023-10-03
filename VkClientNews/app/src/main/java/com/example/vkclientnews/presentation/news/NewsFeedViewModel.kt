package com.example.vkclientnews.presentation.news

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.vkclientnews.data.repository.NewsFeedRepository
import com.example.vkclientnews.domain.FeedPost
import com.example.vkclientnews.extensions.mergeWith
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class NewsFeedViewModel(application: Application) : AndroidViewModel(application) {

    private val exceptionHandler = CoroutineExceptionHandler{_,_ ->
        Log.d("NewsFeedViewModel","Exception caught by exception handler")
    }
    private val repository = NewsFeedRepository(application)
    private val recommendationsFlow = repository.recommendations


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
            repository.loadNextData()
        }
    }



    fun changeLikeStatus(feedPost: FeedPost) {
        viewModelScope.launch(exceptionHandler) {
             repository.changeStatus(feedPost)
        }
    }


    fun remove(feedPost: FeedPost) {
        viewModelScope.launch(exceptionHandler) {
            repository.deletePost(feedPost)
        }
    }

}