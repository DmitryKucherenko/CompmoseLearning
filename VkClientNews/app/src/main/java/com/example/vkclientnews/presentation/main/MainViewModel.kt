package com.example.vkclientnews.presentation.main

import android.app.Application
import androidx.lifecycle.*
import com.example.vkclientnews.data.repository.NewsFeedRepository
import com.example.vkclientnews.data.repository.NewsFeedRepositoryImpl
import com.example.vkclientnews.domain.entity.AuthState
import com.example.vkclientnews.domain.usecases.CheckAuthUseCase
import com.example.vkclientnews.domain.usecases.GetAuthStateFlowUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getAuthStateFlowUseCase: GetAuthStateFlowUseCase,
    private val checkAuthStateFlowUseCase: CheckAuthUseCase
) : ViewModel() {

    var authState: StateFlow<AuthState> = getAuthStateFlowUseCase()

    fun performAuthResult() {
        viewModelScope.launch {
            checkAuthStateFlowUseCase()
        }
    }


}