package com.example.vkclientnews.presentation.main

sealed class AuthState {
    object Authorized : AuthState()
    object NotAuthorized : AuthState()
    object Initial: AuthState()
}